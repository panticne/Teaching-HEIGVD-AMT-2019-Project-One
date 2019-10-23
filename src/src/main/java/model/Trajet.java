package model;

public class Trajet {
    private final String start;
    private final String end;
    private final int time;

    public Trajet(String start, String end, int time) {
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
}
