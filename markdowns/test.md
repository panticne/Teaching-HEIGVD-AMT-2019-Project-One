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

Afin de tester notre pagination nous avons utilisé JMeter afin de calculer le temps mis par notre solution avec pagination vs celle sans pagination. 

Nous nous sommes donc mis à tester des accès à nos pages et les résultats sont les suivants :

Le nombre d'entrée total étant de 1'000'000.

Pour 100 requêtes sans pagination le temps moyen était de 19698 ms

Pour 100 requêtes avec pagination le temps moyen était de 33 ms (on affiche 10 lignes)

Avec ces résultats nous pouvons très nettement constater l'avantage que offre la pagination lorsque le nombre d'élément à afficher tend vers l'infini.

Pour appuyer ce propos nous avons lancé le même test sur une DB contenant 1000 lignes

Pour 100 requêtes sans pagination le temps moyen était de 673 ms

Pour 100 requêtes avec pagination le temps moyen était de 31 ms (on affiche 10 lignes)

Tous ces nombres sont des moyennes de temps d'exécution.
