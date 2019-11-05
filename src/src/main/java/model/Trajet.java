package model;

import javax.persistence.Entity;

@Entity
public class Trajet {
    private final int id;
    private final String start;
    private final String end;
    private final int time;

    public Trajet(int id, String start, String end, int time) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.time = time;
    }

    public int getTime() {
        return time;
    }
    public String getEnd() {
        return end;
    }
    public String getStart() {
        return start;
    }
    public int getId() {
        return id;
    }
}
