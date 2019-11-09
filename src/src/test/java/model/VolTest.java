package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class VolTest {
    @Test
    public void itShouldHaveAConstructor() {
        Avion avion = new Avion(1, "Swiss air", "A380");
        Pilote pilote = new Pilote("David", "Simeonovic", "dado", "password");
        Trajet trajet = new Trajet(1, "Genève", "Milan", 60);
        Vol vol = new Vol(1, avion, pilote, trajet);
        assertEquals(1, vol.getId());
        assertEquals(avion, vol.getAvion());
        assertEquals(pilote, vol.getPilote());
        assertEquals(trajet, vol.getTrajet());
    }

}