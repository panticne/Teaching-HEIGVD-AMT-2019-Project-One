import random
import time
import config
config = config.config

class Table:
    def __init__(self, name):
        self.name = name
        self.outdegree = 0
        self.columns = []
        self.dummy_rows = []
        #When this table has been processed, for each table in self.child_tables, decrement their outdegree by 1
        self.child_tables = set()

    def __str__(self):
        return self.name

    @staticmethod
    def find_column(table, column_name):
        return next(obj for obj in table.columns if obj.name == column_name)

    def add_foreign_key(self, this_column_name, other_table, other_column_name):
        this_column = Table.find_column(self, this_column_name)
        other_column = Table.find_column(other_table, other_column_name)
        this_column.parent_column_ref = other_column
        self.outdegree += 1
        other_table.child_tables.add(self)

    def insert_rows(self):
        for i in range(config.row_count):
            row = []
            for column in self.columns:
                row.append(repr(column.dummy_data[i]))
            self.dummy_rows.append("({0}){1}\n".format(', '.join(row), "," if i < config.row_count-1 else ";"))
    
class Column:
    INTEGER_TYPES = set(["tinyint", "smallint", "int", "mediumint", "bigint"])
    DECIMAL_TYPES = set(["decimal", "float," "double", "real"])
    CHAR_TYPES = set(["char", "varchar", "tinytext", "text", "mediumtext", "longtext"])
    DATE_FORMATS = {
        "date": '%Y-%m-%d',
        "year": '%Y',
        "datetime": '%Y-%m-%d '
    }

    def __init__(self, name, type, length=0):
        self.name = name
        self.type = type
        self.length = length
        self.pk = False
        self.auto_increment = False
        #Record parent column
        self.parent_column_ref = None
        self.dummy_data = []

    def __contains__(self, key):
        return key == self.name

    def __repr__(self):
        return self.name

    def __str__(self):
        return self.name

    @staticmethod
    def str_time_prop(start, end, format, prop):
        """Get a time at a proportion of a range of two formatted times.

        start and end should be strings specifying times formated in the
        given format (strftime-style), giving an interval [start, end].
        prop specifies how a proportion of the interval to be taken after
        start.  The returned time will be in the specified format.
        """

        stime = time.mktime(time.strptime(start, format))
        etime = time.mktime(time.strptime(end, format))

        ptime = stime + prop * (etime - stime)

        return time.strftime(format, time.localtime(ptime))

    @staticmethod
    def random_date(start, end, prop):
        return Column.str_time_prop(start, end, '%Y-%m-%d', prop)

    def generate_data(self):
        if self.parent_column_ref:
            self.dummy_data = [random.choice(self.parent_column_ref.dummy_data) for i in range(config.row_count)]
        elif self.type == "date":
            self.dummy_data = [Column.random_date("1971-01-01", "2019-01-01", random.random()) for i in range(config.row_count)]
        elif self.type in Column.INTEGER_TYPES:
            if self.auto_increment:
                self.dummy_data = [i for i in range(1, config.row_count+1)]
            else:
                self.dummy_data = [random.randint(1, 9999) for i in range(config.row_count)]
        elif self.type in Column.DECIMAL_TYPES:
            if self.auto_increment:
                self.dummy_data = [i for i in range(1, config.row_count+1)]
            else:
                self.dummy_data = [random.random() * 9999 for i in range(config.row_count)]
        elif self.type in Column.CHAR_TYPES:
            self.dummy_data = [(self.name + str(i))[:self.length] for i in range(1, config.row_count+1)]