package com.example.virus;

import com.example.virus.model.People;
import com.example.virus.model.Viruses;
import com.example.virus.repos.PeopleRepo;
import com.example.virus.repos.VirusesRepo;

import java.util.Random;

public class Generate {
    private final int POPULATION = 11;

    PeopleRepo peopleRepo;
    People people;

    public Generate(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public void generate() {
        if (peopleRepo.count() != 0) {
            peopleRepo.deleteAll();
        }
        for (long i = 1; i < POPULATION; i++) {
            people = new People();
            people.setId(i);
            people.setHealthy("Здоров");
            people.setUnknownDeath("Неизвестно");
            peopleRepo.save(people);
        }
    }

    public void generateInfect(VirusesRepo virusesRepo, long id, int count) {
        Viruses viruses = virusesRepo.findById(id).orElseThrow();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            long rand = 319 + random.nextInt(10);
            people = peopleRepo.findById(rand).orElseThrow();
            people.setHealthy(viruses.getVirusName());
        }
        peopleRepo.save(people);
    }
}
