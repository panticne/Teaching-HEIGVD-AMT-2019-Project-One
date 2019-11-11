# Teaching-HEIGVD-AMT-2019-Project-One

## Bug connu

### Cookie

Il se peut que lorsque vous saisissiez :
```
http://localhost:8080/Project-One
```
le login ne marche pas, comme discuté avec le professeur, il s'agit d'un bug connu qui va "ignorer le cookie". Afin de régler ça vous pouvez essayer de rentrer : 
```
http://<votre-ip>:8080/Project-One
```
"votre-ip" étant votre adresse IP.

### Se connecter

Notre login va : hasher le mot de passe saisi et comparer avec le hash saisi dans la DB
Mais lors de l'insértion, tous les mots de passe générés avec le .sql ne sont pas hashé, ce qui fait que tous les comptes sont innutilisables, vous devez donc vous register au moins une fois avant d'accéder à notre application
