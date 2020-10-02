package com.example.virus;

import com.example.virus.model.Illness;
import com.example.virus.model.People;
import com.example.virus.model.Viruses;
import com.example.virus.repos.IllnessRepo;
import com.example.virus.repos.PeopleRepo;
import com.example.virus.repos.VirusesRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Generate {
    private final int POPULATION = 11;

    IllnessRepo illnessRepo;
    VirusesRepo virusesRepo;
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
        for (int i = 0; i < POPULATION - 1; i++) {
            list.add(counter + i);
        }

        Viruses viruses = virusesRepo.findById(id).orElseThrow();
        Random random = new Random();
        Illness illness = new Illness();
        illness.setVirus(viruses.getVirusName());
        illness.setData(new Date());
        illness.setStage((byte) 0);

        for (int i = 0; i < count; i++) {
            int rand = random.nextInt(10);
            people = peopleRepo.findById(list.get(rand)).orElseThrow();
            if (people.getHealthy().equals("Здоров")) {
                people.setHealthy(viruses.getVirusName());
                people.setIllness(illness);
                lifeCycle(people, illness, viruses);
            }

        }
        peopleRepo.save(people);
    }

    //Не самый лучший способ создания потоков, но все же...
    public void lifeCycle(People people, Illness illness, Viruses viruses) {
        final boolean[] flag = {true};
        Thread repeatedTask = new Thread() {
            public void run() {
                while (flag[0]) {
                    int stage = people.getIllness().getStage() + 1;
                    illness.setStage(stage);
                    people.setIllness(illness);
                    //Допустим 6ая стадия репликация , тогда выполняем действия из условия.
                    if (stage > 6) {
                        if (stage < viruses.getAverageTimeOfInfection()) {
                            Random random = new Random();
                            if (random.nextInt(100) < viruses.getMortality()) {
                                people.setHealthy("Умер");
                                people.setInfectionDate(new Date());
                            } else {
                                people.setHealthy("Здоров");
                                people.setInfectionDate(new Date(0));
                            }
                            peopleRepo.save(people);
                        }
                        flag[0] = false;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        repeatedTask.start();
    }
}
