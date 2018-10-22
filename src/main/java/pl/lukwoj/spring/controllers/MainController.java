package pl.lukwoj.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lukwoj.spring.PersonRepository;
import pl.lukwoj.spring.model.Person;
import pl.lukwoj.spring.model.SimpleBean;
import pl.lukwoj.spring.model.forms.PersonForm;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class MainController {
    @Autowired
    SimpleBean simpleBean;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String request() {
        return "Get method: " + "random string from bean: " + simpleBean.generateString();
    }


    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public String postData(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "age") int age) {
        return "Your name is: " + name + ", surname is: " + surname + ((age >= 18) ? " - you are adult" : " - you are underage");
    }

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
        //return "Dane z klasy Person: " + person.getName();
    }
}
