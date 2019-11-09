package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PiloteTest {
    @Test
    public void itShouldHaveAConstructor() {
        Pilote pilote = new Pilote("David", "Simeonovic", "dado", "password");
        assertEquals("David", pilote.getPrenom());
        assertEquals("Simeonovic", pilote.getNom());
        assertEquals("dado", pilote.getPseudo());
        assertEquals("password", pilote.getMotdepasse());
    }
}