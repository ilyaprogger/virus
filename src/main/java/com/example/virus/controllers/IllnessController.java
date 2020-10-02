package com.example.virus.controllers;

import com.example.virus.repos.IllnessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IllnessController {
    @Autowired
    IllnessRepo illnessRepo;

    @GetMapping("/illness")
    public String illness(Model model){
        return "/illness";
    }
}
