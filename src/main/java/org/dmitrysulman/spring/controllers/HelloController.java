package org.dmitrysulman.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class HelloController {
    @GetMapping({"/hello-world", "/test1"})
    public String sayHello(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "hello/hello_world";
    }

    @GetMapping({ "/test"})
    public String sayHello2(@RequestParam("name") String name) {
        return "hello/test";
    }

    @GetMapping({ "/test3"})
    public String sayHello3(@RequestParam(value = "name", required = false) String name) {
        return "hello/test";
    }
}
