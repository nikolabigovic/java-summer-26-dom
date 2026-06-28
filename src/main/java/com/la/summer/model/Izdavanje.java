package com.la.summer.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name="izdavanje")
@Getter
@Setter
public class Izdavanje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="knjigaId")
    private Knjiga knjiga;

    @ManyToOne
    @JoinColumn(name="izdaoKorisnik")
    private Korisnik  izdaoKorisnik;

    @ManyToOne
    @JoinColumn(name="pozajmioKorisnikId")
    private Korisnik pozajmioKorisnik;

    @Column(name="datumIzdavanja")
    private Instant datumIzdavanja;

    @Column(name="datumVracanja")
    private Instant datumVracanja;

}
