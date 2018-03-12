package pl.lukwoj.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lukwoj.spring.model.SimpleBean;

@Controller
public class MainController {

    @Autowired
    SimpleBean simpleBean;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainGet(Model model) {
        model.addAttribute("someString", "String from Controller");
        return "index";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody//ponieważ nie zwracamy nowego widoku
    public String postData(@RequestParam(value = "name", required = false) String nameFromForm) {
        return "Your name is: " + nameFromForm;
    }
}

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainGet() {
        return "index";
    }*/

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String mainGet() {
        return "<b>Hello Lukasz GET</b> : " + simpleBean.generateString();
    }*/

