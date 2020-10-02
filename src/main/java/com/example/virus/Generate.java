package com.example.virus;

import com.example.virus.model.Illness;
import com.example.virus.model.People;
import com.example.virus.model.Viruses;
import com.example.virus.repos.IllnessRepo;
import com.example.virus.repos.PeopleRepo;
import com.example.virus.repos.VirusesRepo;

import java.util.*;

public class Generate {
    private final int POPULATION = 11;

    IllnessRepo illnessRepo;
    PeopleRepo peopleRepo;
    People people;
    Illness illness;
    List<Long> list = new ArrayList<>();


    public Generate(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public void generate() {
        list = new ArrayList<>();
        if (peopleRepo.count() != 0) {
            peopleRepo.deleteAll();
        }
        for (long i = 1; i < POPULATION; i++) {
            people = new People();
            people.setIllness(illness);
            people.setHealthy("Здоров");
            people.setInfectionDate(new Date(0));
            peopleRepo.save(people);
        }
    }

    public void generateInfect(VirusesRepo virusesRepo, long id, int count) {
        Iterable<People> peopler = peopleRepo.findAll();
        long counter = peopler.iterator().next().getId();
        for (int i = 0; i < POPULATION -1; i++) {
            list.add(counter + i);
        }

        Viruses viruses = virusesRepo.findById(id).orElseThrow();
        Random random = new Random();
        Illness illness = new Illness();
        illness.setVirus(viruses.getVirusName());
        illness.setData(new Date());
        illness.setStage((byte) 1);

        for (int i = 0; i < count; i++) {
            int rand = random.nextInt(10);
            people = peopleRepo.findById(list.get(rand)).orElseThrow();
            if (people.getHealthy().equals("Здоров")) {
                people.setHealthy(viruses.getVirusName());
                people.setIllness(illness);
            }
            else{
                people.setHealthy(people.getHealthy()+","+viruses.getVirusName());

            }

        }
        peopleRepo.save(people);
    }
}
