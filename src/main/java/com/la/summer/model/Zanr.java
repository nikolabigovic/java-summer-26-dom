package com.la.summer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "zanr")
public class Zanr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "naziv", length = 300)
    private String naziv;

    @Column(name = "opis", length = 1000)
    private String opis;

    @OneToMany(mappedBy = "zanr")
    private List<Knjiga> knjigaList = new ArrayList<>();


}