package pl.ba51602.lab9;

public class Person {
    private String firstName;
    private String familyName;

    // Pusty konstruktor (wymagany przez Springa przy formularzach)
    public Person() {}

    // Konstruktor z parametrami (dla wygody)
    public Person(String firstName, String familyName) {
        this.firstName = firstName;
        this.familyName = familyName;
    }

    // Gettery i Settery
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}