package model;

public class Avion {
    private final int id;
    private final String company;
    private final String type;

    public Avion(int id, String company, String type) {
        this.id = id;
        this.company = company;
        this.type = type;
    }

    public String getCompany() {
        return company;
    }
    public String getType() {
        return type;
    }
    public int getId() {
        return id;
    }
}
