package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvionTest {

    @Test
    public void itShouldHaveAConstructor() {
        Avion avion = new Avion(1, "Swiss air", "A380");
        assertEquals(1, avion.getId());
        assertEquals("Swiss air", avion.getCompagnie());
        assertEquals("A380", avion.getType());
    }
}