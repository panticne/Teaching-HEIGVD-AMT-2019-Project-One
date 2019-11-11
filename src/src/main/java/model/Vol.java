package model;

import javax.persistence.Entity;

@Entity
public class Vol {
    private final int id;
    private final Avion avion;
    private final Pilote pilote;
    private final Trajet trajet;

    /**
     * Constructeur
     * @param id Id du vol
     * @param avion Avion du vol
     * @param pilote Pilote du vol
     * @param trajet Trajtet du vol
     */
    public Vol(int id, Avion avion, Pilote pilote, Trajet trajet){
        this.id = id;
        this.avion = avion;
        this.pilote = pilote;
        this.trajet = trajet;
    }

    /**
     * Permet de récupérer l'avion
     * @return Avion
     */
    public Avion getAvion() {
        return avion;
    }

    /**
     * Permet de récupérer le pilote
     * @return Pilote
     */
    public Pilote getPilote() {
        return pilote;
    }

    /**
     * Permet de récupérer le trajet
     * @return Trajet
     */
    public Trajet getTrajet() {
        return trajet;
    }

    /**
     * Permet de récupérer l'id du vol
     * @return Id
     */
    public int getId() {
        return id;
    }
}
