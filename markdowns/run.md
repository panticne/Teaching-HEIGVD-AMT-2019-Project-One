# Teaching-HEIGVD-AMT-2019-Project-One

## Run project

Pour générer le .sql vous pouvez vous rendre dans le dossier /mysql-dummy-data et lancer cette commande
```
python main.py mysqldump_dump.sql --rows 1000000 --output ../data/output.sql
```
Vous pouvez spécifier le nombre de lignes à insérer à la suite --rows

Pour lancer l'infrastructure il vous suffit de vous rendre sur /topology-amt et de lancer la commande

```
docker-compose up --build
```
Vous aurez à ce moment une base de données SQL qui va se peupler toute seule ainsi qu'un serveur payara qui va charger notre application qui sera accessible à l'adresse
```
http://localhost:8080/Project-One
```

Source : https://github.com/peterg98/mysql-dummy-data
