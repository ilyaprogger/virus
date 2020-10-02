package com.example.virus.model;

import com.example.virus.repos.IllnessRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
public class People {
    @Id
    @GeneratedValue
    private Long id;

    public People(String healthy) {
        this.healthy = healthy;

    }

    private String healthy;
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