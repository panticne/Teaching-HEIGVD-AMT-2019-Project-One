package model;

import javax.persistence.Entity;

@Entity
public class Vol {
    private final int id;
    private final Avion avion;
    private final Pilote pilote;
    private final Trajet trajet;

    public Vol(int id, Avion avion, Pilote pilote, Trajet trajet){
        this.id = id;
        this.avion = avion;
        this.pilote = pilote;
        this.trajet = trajet;
    }

    public Avion getAvion() {
        return avion;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public int getId() {
        return id;
    }
}
