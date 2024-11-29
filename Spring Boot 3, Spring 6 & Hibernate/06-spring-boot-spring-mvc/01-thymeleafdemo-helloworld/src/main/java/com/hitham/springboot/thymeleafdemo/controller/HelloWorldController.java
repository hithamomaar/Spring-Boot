package com.hitham.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letShoutdude(HttpServletRequest request, Model model) {

        String s = request.getParameter("studentName");

        String result = "YO! " + s.toUpperCase();

        model.addAttribute("message", result);

        return "helloworld";
    }

//    @GetMapping("/processFormVersionThree")
    @PostMapping("/processFormVersionThree")
    public String processFormV3(@RequestParam("studentName") String name, Model model) {

        String result = "Hey My Friend from v3! " + name.toUpperCase();

        model.addAttribute("message", result);

        return "helloworld";
    }
}
