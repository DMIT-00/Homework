package it.academy.homework6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping({"/", "welcome.html"})
    public String homepage(ModelAndView modelAndView) {
        modelAndView.addObject("greeting", "Hello, User!");
        System.out.println("Welcome");
        return "welcome";
    }
}
