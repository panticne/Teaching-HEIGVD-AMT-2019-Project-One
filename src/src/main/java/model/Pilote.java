package model;

import javax.persistence.Entity;

@Entity
public class Pilote {
    private final String prenom;
    private final String nom;
    private final String pseudo;
    private final String motdepasse;

    /**
     * Constructeur
     * @param prenom Prénom du pilote
     * @param nom Nom du pilote
     * @param pseudo Pseudo du pilote
     * @param motdepasse Mot de passe du pilote
     */
    public Pilote(String prenom, String nom, String pseudo, String motdepasse){
        this.prenom = prenom;
        this.nom = nom;
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;
    }

    /**
     * Permet de récupérer le mot de passe
     * @return Mot de passe
     */
    public String getMotdepasse() {
        return motdepasse;
    }

    /**
     * Permet de récupérer le nom
     * @return Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet de récupérer le prénom
     * @return Prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Permet de récupérer le pseudo
     * @return Pseudo
     */
    public String getPseudo() {
        return pseudo;
    }
}
