package pl.ba51602.lab9;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    private final PersonService personService;

    // Wstrzyknięcie serwisu przez konstruktor
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Widok listy osób
    @GetMapping("/people")
    public String showPeople(Model model) {
        model.addAttribute("peopleList", personService.getPeople());
        return "people"; // szuka pliku people.html
    }

    // Widok formularza dodawania
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "add-person"; // szuka pliku add-person.html
    }

    // Obsługa wysłania formularza (POST)
    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personService.addPerson(person);
        return "redirect:/people"; // przekierowanie z powrotem na listę
    }
}