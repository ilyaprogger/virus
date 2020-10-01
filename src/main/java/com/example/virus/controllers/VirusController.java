package com.example.virus.controllers;

import com.example.virus.VirusType;
import com.example.virus.model.Viruses;
import com.example.virus.repos.VirusesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VirusController {
    @Autowired
    VirusesRepo virusesRepo;

    @GetMapping("/virus")
    public String virus(Model model) {
        Iterable<Viruses> viruses = virusesRepo.findAll();
        model.addAttribute("viruses", viruses);
        return "virus";
    }

    @GetMapping("/virus/add")
    public String addVirus(Model model) {
        return "virus-add";
    }
    @PostMapping("/virus")
    public String deleteVirus(@RequestParam long id, Model model) {
        Viruses virus = virusesRepo.findById(id).orElseThrow();
        virusesRepo.delete(virus);
        return "redirect:/virus";
    }

    @PostMapping("/virus/add")
    public String virusPost(@RequestParam VirusType virusType, @RequestParam String virusName, @RequestParam int
            chanceOfInfection, @RequestParam int averageTimeOfInfection, @RequestParam int
                                    mortality, @RequestParam int chanceOfReInfection,
                            Model model) {
      Viruses viruses = new Viruses(virusType,virusName, chanceOfInfection,
              averageTimeOfInfection, mortality, chanceOfReInfection);
        virusesRepo.save(viruses);

        return "redirect:/virus";
    }

}
