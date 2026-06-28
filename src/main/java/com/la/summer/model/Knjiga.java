package com.la.summer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "knjiga")
public class Knjiga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "naslov", length = 300)
    private String naslov;

    @Column(name = "broj_strana")
    private Integer brojStrana;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "datum_izdavanja")
    private Instant datumIzdavanja;


//    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "zanr_id")
    private Zanr zanr;

    @ManyToOne
    @JoinColumn(name = "izdavac_id")
    private Izdavac izdavac;

}