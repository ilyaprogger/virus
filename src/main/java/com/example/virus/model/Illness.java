package com.example.virus.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


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

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public Illness(String virus, Date data, int stage) {
        this.virus = virus;
        this.data = data;
        this.stage = stage;
    }

    private String virus;
    private Date data;
    private int stage;

    public Illness() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
