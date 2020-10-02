package com.example.virus;

import com.example.virus.model.Illness;
import com.example.virus.model.People;
import com.example.virus.model.Viruses;
import com.example.virus.repos.IllnessRepo;
import com.example.virus.repos.PeopleRepo;
import com.example.virus.repos.VirusesRepo;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generate {
    private final int POPULATION = 11;

    IllnessRepo illnessRepo;
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
            people.setInfectionDate(new Date(0));
            peopleRepo.save(people);
        }
    }

    public void generateInfect(VirusesRepo virusesRepo, long id, int count) {
        Viruses viruses = virusesRepo.findById(id).orElseThrow();
        Random random = new Random();
        Illness illness =  new Illness();
        illness.setVirus(viruses.getVirusName());
        illness.setData(new Date());
        illness.setStage((byte)1);
        Set<Long> countset = new HashSet<>();
        for (int i = 0; i < count; i++) {
            long rand = 1 + random.nextInt(11);
            if(countset.contains(rand)){
                continue;
            }
            people = peopleRepo.findById(rand).orElseThrow();
            if(!people.getHealthy().equals("Здоров"))
            people.setHealthy(people.getHealthy() + "," + viruses.getVirusName());
            else people.setHealthy(viruses.getVirusName());
            people.setIllness(illness);
            countset.add(rand);
        }
        peopleRepo.save(people);
    }
}
