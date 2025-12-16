package pl.ba51602.lab9;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private List<Person> people = new ArrayList<>();

    // Inicjalizacja danych startowych
    @PostConstruct
    public void init() {
        people.add(new Person("Jan", "Kowalski"));
        people.add(new Person("Anna", "Nowak"));
    }

    // Pobranie wszystkich
    public List<Person> getPeople() {
        return people;
    }

    // Dodanie osoby
    public void addPerson(Person person) {
        people.add(person);
    }

    // Pobranie konkretnej osoby (używamy indeksu listy jako ID)
    public Person getPerson(int index) {
        if (index >= 0 && index < people.size()) {
            return people.get(index);
        }
        return null;
    }
    
    // Aktualizacja osoby (setPerson)
    public boolean setPerson(int index, Person person) {
        if (index >= 0 && index < people.size()) {
            people.set(index, person);
            return true;
        }
        return false;
    }

    // Usunięcie osoby
    public boolean removePerson(int index) {
        if (index >= 0 && index < people.size()) {
            people.remove(index);
            return true;
        }
        return false;
    }
}