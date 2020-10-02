package com.example.virus.model;

import com.example.virus.repos.IllnessRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@OneToOne(mappedBy = "illness", cascade = CascadeType.ALL)
    //private People people;

    public String getVirus() {
        return virus;
    }

    public void setVirus(String virus) {
        this.virus = virus;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public byte getStage() {
        return stage;
    }

    public void setStage(byte stage) {
        this.stage = stage;
    }

    public Illness(String virus, Date data, byte stage) {
        this.virus = virus;
        this.data = data;
        this.stage = stage;
    }

    private String virus;
    private Date data;
    private byte stage;

    public Illness() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    //public People getPeople() {
    //    return people;
    //}

    // public void setPeople(People people) {
    //     this.people = people;
    // }
}
