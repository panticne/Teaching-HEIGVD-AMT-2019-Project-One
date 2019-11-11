# Teaching-HEIGVD-AMT-2019-Project-One

## Test

Nous avons implémenté une série de test sur :

1. Chacun de nos modèles avec JUnit
2. Certaines DAO avec Arquillian

Le but de nos tests est de valider le fait que les méthodes qui ont été implémentée soient fonctionelles.

Par exemple nous effectuons des tests afin de créer un de nos modèles. Voici un exemple :

```
public class TrajetTest {
    @Test
    public void itShouldHaveAConstructor() {
        Trajet trajet = new Trajet(1, "Genève", "Milan", 60);
        assertEquals(1, trajet.getId());
        assertEquals("Genève", trajet.getStart());
        assertEquals("Milan", trajet.getEnd());
        assertEquals(60, trajet.getTime());
    }
}
```

Les tests avec Arquillian sont plutôt orienté méthode, on va par exemple tester que l'on puisse modifier des vols

```
    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToChangeVol() throws SQLException{
        Vol vol = volDAOLocal.getVolById(1);
        Avion actuelAvion = vol.getAvion();
        Trajet actuelTrajet = vol.getTrajet();

        volDAOLocal.changerVolbyPilote(1, 2, 2 );

        vol = volDAOLocal.getVolById(1);

        assertNotEquals(actuelAvion.getId(), vol.getAvion().getId());
        assertNotEquals(actuelTrajet.getId(), vol.getTrajet().getId());
    }
```

Afin de lancer ces tests, il vous faudra lancer les commandes suivantes :

### Pagination


