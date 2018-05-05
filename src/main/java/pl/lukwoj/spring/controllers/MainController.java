package pl.lukwoj.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lukwoj.spring.model.Person;
import pl.lukwoj.spring.model.SimpleBean;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.logging.Logger;

@Controller
public class MainController {


    @Autowired
    SimpleBean simpleBean;

    @RequestMapping("/lukasz")
    @ResponseBody
    public String main() {
        return "lukasz";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String response() {
        return "Post method";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String request() {
        return "Get method: " + "random string from bean: " + simpleBean.generateString();
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String responseTemplate(Model model) {
        LocalDateTime now = LocalDateTime.now();

        if (now.getHour() > 1) {
            model.addAttribute("someString", "Time to go home");
        } else {
            model.addAttribute("someString", "We are learning");
        }

        return "index";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public String postData(@RequestParam(value = "name") String name,
                           @RequestParam(value = "surname") String surname,
                           @RequestParam(value = "age") int age) {
        return "Your name is: " + name + ", surname is: " + surname + ((age >= 18) ? " - you are adult" : " - you are underage");
    }

    @RequestMapping(value = "/newform", method = RequestMethod.GET)
    public String newform(Model model) {
        model.addAttribute("personObject", new Person());
        return "form";
    }

    @RequestMapping(value = "/newform", method = RequestMethod.POST)
    public String newformPost(@ModelAttribute("personObject") @Valid Person person, BindingResult result){
        if(result.hasErrors()){
            return "form";
        }
        return "result";
        //return "Dane z klasy Person: " + person.getName();
    }
    // Testujemy jak działa wzorzec builder ;)
// Nie ma wpływu na działanie springa
    private void testBuilder() {
        Person person = new Person.Builder("Oskar").setAge(27).setEmail("lukasz@wp.pl").setSurname("Wojciech").setMobile("454-556-555").build();
        person.getAge();
    }
}
