package model;

import javax.persistence.Entity;

@Entity
public class Pilote {
    private final String prenom;
    private final String nom;
    private final String pseudo;
    private final String motdepasse;

    public Pilote(String prenom, String nom, String pseudo, String motdepasse){

        this.prenom = prenom;
        this.nom = nom;
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;

    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }
}
