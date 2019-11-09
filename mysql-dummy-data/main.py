import collections, re
import time
import copy
import config
from constants import *
from models import *

tables = dict()
dummy_rows = dict()

def initial_read_phpmyadmin():
    with open(config.input_file, "r") as f:
        line = f.readline()
        current_table_name = ""
        while line:
            create_table = re.match(CREATE_TABLE_REGEX, line)
            alter_table = re.match(ALTER_TABLE_REGEX, line)
            primary_key = re.match(PRIMARY_KEY_REGEX_PHPMYADMIN, line)
            row_entry = re.match(TABLE_COLUMN_REGEX, line)
            row_entry_date = re.match(TABLE_COLUMN_REGEX_DATE, line)
            foreign_key = re.match(FOREIGN_KEY_REGEX_PHPMYADMIN, line)
            auto_increment = re.match(AUTO_INCREMENT_REGEX, line)
            if create_table:
                current_table_name = create_table.group('table_name')
                tables[current_table_name] = Table(current_table_name)
            elif row_entry:
                tables[current_table_name].columns.append(Column(row_entry.group('column_name'), row_entry.group('type'), length=int(row_entry.group('length'))))
            elif row_entry_date:
                tables[current_table_name].columns.append(Column(row_entry_date.group('column_name'), row_entry_date.group('type')))
            elif alter_table:
                current_table_name = alter_table.group('table_name')
            elif foreign_key:
                other_table_name = foreign_key.group('other_table')
                other_column_name = foreign_key.group('other_column')
                this_column_name = foreign_key.group('foreign_key')
                tables[current_table_name].add_foreign_key(this_column_name, tables[other_table_name], other_column_name)
            elif primary_key:
                column = Table.find_column(tables[current_table_name], primary_key.group('primary_key'))
                column.pk = True
            elif auto_increment:
                column = Table.find_column(tables[current_table_name], auto_increment.group('column_name'))
                column.auto_increment = True
            line = f.readline()
    #Original tables variable will be used for topological pruning of the graph,
    #the copy will be used as 
    return copy.copy(tables)

def initial_read_mysqldump():
    foreign_keys = []
    with open(config.input_file, "r") as f:
        line = f.readline()
        current_table_name = ""
        while line:
            create_table = re.match(CREATE_TABLE_REGEX, line)
            primary_key = re.match(PRIMARY_KEY_REGEX_MYSQLDUMP, line)
            row_entry = re.match(TABLE_COLUMN_REGEX, line)
            row_entry_date = re.match(TABLE_COLUMN_REGEX_DATE, line)
            foreign_key = re.match(FOREIGN_KEY_REGEX_MYSQLDUMP, line)
            if create_table:
                current_table_name = create_table.group('table_name')
                tables[current_table_name] = Table(current_table_name)
            elif row_entry:
                column = Column(row_entry.group('column_name'), row_entry.group('type'), length=int(row_entry.group('length')))
                tables[current_table_name].columns.append(column)
                if 'AUTO_INCREMENT' in line:
                    column.auto_increment = True
            elif row_entry_date:
                tables[current_table_name].columns.append(Column(row_entry_date.group('column_name'), row_entry_date.group('type')))
            elif foreign_key:
                other_table_name = foreign_key.group('other_table')
                other_column_name = foreign_key.group('other_column')
                this_column_name = foreign_key.group('foreign_key')
                foreign_keys.append((tables[current_table_name], this_column_name, other_table_name, other_column_name))
            elif primary_key:
                column = Table.find_column(tables[current_table_name], primary_key.group('primary_key'))
                column.pk = True
            line = f.readline()
    #Process foreign keys after structure has been set, otherwise there will be an error because
    #foreign keys might reference non-existing tables
    for table, this_column_name, other_table_name, other_column_name in foreign_keys:
        table.add_foreign_key(this_column_name, tables[other_table_name], other_column_name)
    return copy.copy(tables)

def write_to_sql():
    with open(config.input_file, 'r') as input, open(config.output_file, 'w') as output:
        line = input.readline()
        current_table_name = None
        while line:
            create_table = re.match(CREATE_TABLE_REGEX, line)
            if create_table:
                current_table_name = create_table.group('table_name')
            elif line.startswith(")"):
                output.write(line)
                line = input.readline()
                output.write(line)
                line = input.readline()
                for row in generate_insert_clause(current_table_name):
                    output.write(row)
                continue
            output.write(line)
            line = input.readline()
        
def generate_insert_clause(table_name):
    table = tables_copy[table_name]
    columns = list(map(lambda column: "`{}`".format(column.name), table.columns))
    lines = ["INSERT INTO `{0}` ({1}) VALUES\n".format(table_name, ', '.join(columns))]
    lines.extend(table.dummy_rows)
    return lines

if __name__ == "__main__":
    import argparse

    parser = argparse.ArgumentParser(description="Generates dummy data given a MySQL dump file.")
    parser.add_argument('input_file')
    parser.add_argument('--rows', help="Enter the desired number of rows.", type=int, default=10)
    parser.add_argument('--phpmyadmin', help="Use this flag if the dump was exported using phpmyadmin", action='store_true')
    parser.add_argument('--output', help="Set the output file name. Default is output.sql.", type=str, default="output.sql")
    args = parser.parse_args()
    config.row_count = args.rows
    config.input_file = args.input_file
    config.output_file = args.output
    tables_copy = initial_read_mysqldump() if not args.phpmyadmin else initial_read_phpmyadmin()
    while tables:
        queue = collections.deque()
        #Process tables that have no dependencies
        for table_name in list(tables):
            if tables[table_name].outdegree == 0:
                queue.append(tables[table_name])
                del tables[table_name]
        while queue:
            table = queue.popleft()
            for column in table.columns:
                column.generate_data()
            for child_table in table.child_tables:
                #Decrement parent table's outdegree by 1, now that this child table
                #has been processed
                child_table.outdegree -= 1
            table.insert_rows()
            dummy_rows[table.name] = table.dummy_rows
    write_to_sql()
            