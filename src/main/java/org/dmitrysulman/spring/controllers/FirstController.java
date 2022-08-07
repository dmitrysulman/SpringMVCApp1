package org.dmitrysulman.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println(name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname",required = false) String surname,
                              Model model) {

        //System.out.println(name + " " + surname);

        model.addAttribute("message", name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model) {
        switch (action) {
            case "multiplication" -> model.addAttribute("result", a * b);
            case "addition" -> model.addAttribute("result", a + b);
            case "subtraction" -> model.addAttribute("result", a - b);
            case "division" -> model.addAttribute("result", a / (double) b);
            default -> model.addAttribute("result", "Wrong action!");
        }
        return "first/calculator";
    }
}
