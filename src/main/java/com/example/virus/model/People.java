package com.example.virus.model;

import javax.persistence.*;

import java.util.Date;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Date death;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    Illness illness;

    public String getHealthy() {
        return healthy;
    }

    public void setHealthy(String healthy) {
        this.healthy = healthy;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

    public People(String healthy, Date death) {
        this.healthy = healthy;
        this.death = death;
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
                ", death=" + death +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public Illness getIllness() {
    //    return illness;
    //}

    //public void setIllness(Illness illness) {
    //    this.illness = illness;
    //}
}
