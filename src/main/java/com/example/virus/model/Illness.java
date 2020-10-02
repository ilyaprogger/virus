package com.example.virus.model;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class Illness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

  //@OneToOne(mappedBy = "illness", cascade = CascadeType.ALL)
  //private People people;

    public Illness(Long id, String virus, LocalDate data) {
        this.virus = virus;
        this.data = data;
    }

    private String virus;
    private LocalDate data;
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
