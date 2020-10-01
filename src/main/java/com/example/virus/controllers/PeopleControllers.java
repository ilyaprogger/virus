package com.example.virus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeopleControllers {

    @GetMapping("/people")
    public String people(Model model){
        model.addAttribute("people","Люди");
        return "people";
    }
}
