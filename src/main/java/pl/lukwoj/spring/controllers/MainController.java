package pl.lukwoj.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.lukwoj.spring.PersonRepository;
import pl.lukwoj.spring.model.Person;
import pl.lukwoj.spring.model.forms.PersonForm;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/newform", method = RequestMethod.GET)
    public String newForm(Model model) {
        model.addAttribute("personObject", new PersonForm());
        return "form";
    }

    @RequestMapping(value = "/newform", method = RequestMethod.POST)
    public String newFormPost(@ModelAttribute("personObject") @Valid PersonForm personForm, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        Person personObject = new Person(personForm);
        personRepository.save(personObject);
        return "result";
    }
}
