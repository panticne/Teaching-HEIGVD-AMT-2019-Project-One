package model;

import javax.persistence.Entity;

@Entity
public class Avion {
    private final int id;
    private final String compagnie;
    private final String type;

    /**
     * Constructeur
     * @param id Id de l'avion
     * @param compagnie Compagnie de l'avion
     * @param type Type de l'avion
     */
    public Avion(int id, String compagnie, String type) {
        this.id = id;
        this.compagnie = compagnie;
        this.type = type;
    }

    /**
     * Permet de récupérer la compagnie de l'avion
     * @return
     */
    public String getCompagnie() {
        return compagnie;
    }

    /**
     * Permet de récupérer le type de l'avion
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Permet de récupérer l'id de l'avion
     * @return
     */
    public int getId() {
        return id;
    }
}
