package com.example.virus.model;

import javax.persistence.*;

import java.util.Date;

@Entity
public class People {
    @Id
    @GeneratedValue
    private Long id;

    public String getUnknownDeath() {
        return unknownDeath;
    }

    public void setUnknownDeath(String unknownDeath) {
        this.unknownDeath = unknownDeath;
    }

    public People(String healthy, String unknownDeath) {
        this.healthy = healthy;
        this.unknownDeath = unknownDeath;
    }

    String healthy;
    String unknownDeath;
    private Date infectionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    Illness illness;

    public String getHealthy() {
        return healthy;
    }

    public void setHealthy(String healthy) {
        this.healthy = healthy;
    }

    public Date getInfectionDate() {
        return infectionDate;
    }

    public void setInfectionDate(Date infectionDate) {
        this.infectionDate = infectionDate;
    }

    public People(String healthy, Date infectionDate) {
        this.healthy = healthy;
        this.infectionDate = infectionDate;
    }

    public People() {
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", healthy='" + healthy + '\'' +
                ", death=" + infectionDate +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }
}