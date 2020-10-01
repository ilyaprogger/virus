package com.example.virus.model;

import com.example.virus.VirusType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Viruses {
    public Viruses() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private VirusType virusType;
    private String virusName;
    private int chanceOfInfection, averageTimeOfInfection, mortality, chanceOfReInfection;

    public Viruses(VirusType virusType,String virusName, int chanceOfInfection,
                   int averageTimeOfInfection, int mortality, int chanceOfReInfection) {
        this.virusType = virusType;
        this.virusName = virusName;
        this.chanceOfInfection = chanceOfInfection;
        this.averageTimeOfInfection = averageTimeOfInfection;
        this.mortality = mortality;
        this.chanceOfReInfection = chanceOfReInfection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VirusType getVirusType() {
        return virusType;
    }

    public void setVirusType(VirusType virusType) {
        this.virusType = virusType;
    }

    public String getVirusName() {
        return virusName;
    }

    public void setVirusName(String virusName) {
        this.virusName = virusName;
    }

    public int getChanceOfInfection() {
        return chanceOfInfection;
    }

    public void setChanceOfInfection(int chanceOfInfection) {
        this.chanceOfInfection = chanceOfInfection;
    }

    public int getAverageTimeOfInfection() {
        return averageTimeOfInfection;
    }

    public void setAverageTimeOfInfection(int averageTimeOfInfection) {
        this.averageTimeOfInfection = averageTimeOfInfection;
    }

    public int getMortality() {
        return mortality;
    }

    public void setMortality(int mortality) {
        this.mortality = mortality;
    }

    public int getChanceOfReInfection() {
        return chanceOfReInfection;
    }

    public void setChanceOfReInfection(int chanceOfReInfection) {
        this.chanceOfReInfection = chanceOfReInfection;
    }


}
