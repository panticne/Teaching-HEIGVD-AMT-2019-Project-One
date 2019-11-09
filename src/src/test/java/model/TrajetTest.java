package model;

import org.junit.Test;
import services.dao.TrajetDAO;

import static org.junit.Assert.*;

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