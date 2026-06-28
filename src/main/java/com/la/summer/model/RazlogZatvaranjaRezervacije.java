package com.la.summer.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="razlog_zatvaranja_rezervacije")
@Getter
@Setter

public class RazlogZatvaranjaRezervacije {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Naziv")
    private String naziv;
}
