package pl.lukwoj.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lukwoj.spring.model.SimpleBean;

import java.time.LocalDateTime;
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
    public String postData(@RequestParam(value = "name", required = false) String nameFromForm) {
        return "Your name is: " + nameFromForm;
    }
}
