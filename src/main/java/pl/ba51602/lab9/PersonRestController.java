package pl.ba51602.lab9;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping("/{index}")
    public ResponseEntity<Person> getPerson(@PathVariable int index) {
        Person p = personService.getPerson(index);
        return (p != null) ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dodano osobę");
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> removePerson(@PathVariable int index) {
        if (personService.removePerson(index)) {
            return ResponseEntity.ok("Usunięto");
        }
        return ResponseEntity.notFound().build();
    }
}