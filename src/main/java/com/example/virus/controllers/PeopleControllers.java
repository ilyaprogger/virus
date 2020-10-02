package com.example.virus.controllers;

import com.example.virus.Generate;
import com.example.virus.model.People;
import com.example.virus.repos.PeopleRepo;
import com.example.virus.repos.VirusesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PeopleControllers {
    @Autowired
    PeopleRepo peopleRepo;

    @Autowired
    VirusesRepo virusesRepo;

    @GetMapping("/people/infect")
    public String infect(Model model) {
        Iterable<People> people = peopleRepo.findAll();
        model.addAttribute("people", people);
        return "people";
    }

    @PostMapping("/people/infect")
    public String postInfect(@RequestParam int virusId, @RequestParam
            int count, Model model) {
        new Generate(peopleRepo).generateInfect( virusesRepo,  virusId,  count);
        return "redirect:/people";
    }

    @GetMapping("/people")
    public String people(Model model) {
        Iterable<People> people = peopleRepo.findAll();
        model.addAttribute("people", people);
        return "people";
    }

    @PostMapping("/people")
    public String peoplePost() {
        new Generate(peopleRepo).generate();
        return "redirect:/people";
    }

}