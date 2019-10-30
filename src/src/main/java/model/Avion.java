package model;

public class Avion {
    private final int id;
    private final String compagnie;
    private final String type;

    public Avion(int id, String compagnie, String type) {
        this.id = id;
        this.compagnie = compagnie;
        this.type = type;
    }

    public String getCompagnie() {
        return compagnie;
    }
    public String getType() {
        return type;
    }
    public int getId() {
        return id;
    }
}
