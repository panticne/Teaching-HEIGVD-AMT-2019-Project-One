package model;

import javax.persistence.Entity;

@Entity
public class Trajet {
    private final int id;
    private final String start;
    private final String end;
    private final int time;

    /**
     * Constructeur
     * @param id Id du trajet
     * @param start Départ du trajet
     * @param end Arrivée du trajet
     * @param time Temps du trajet
     */
    public Trajet(int id, String start, String end, int time) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.time = time;
    }

    /**
     * Permet de récupérer le temps du trajet
     * @return Time
     */
    public int getTime() {
        return time;
    }

    /**
     * Permet de récupérer l'arrivée du trajet
     * @return
     */
    public String getEnd() {
        return end;
    }

    /**
     * Permet de récupérer le départ du trajet
     * @return
     */
    public String getStart() {
        return start;
    }

    /**
     * Permet de récupérer l'id du trajet
     * @return
     */
    public int getId() {
        return id;
    }
}
