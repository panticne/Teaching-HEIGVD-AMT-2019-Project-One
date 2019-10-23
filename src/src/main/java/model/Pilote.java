package model;

public class Pilote {
    private final String firstname;
    private final String lastname;

    public Pilote(String firstname, String lastname){
        this.firstname=firstname;
        this.lastname=lastname;
    }

    public String getFirstname(){return firstname;}
    public String getLastname(){return lastname;}
}
