package model;

public class Avion {
    private final String company;
    private final String type;

    public Avion(String company, String type) {
        this.company = company;
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public String getType() {
        return type;
    }
}
