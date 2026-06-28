package com.la.summer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name ="rezervacija")
@Getter
@Setter
@ToString(exclude = {"knjiga", "zaKorisnik", "korisnik", "razlogZatvaranja"}) //ZBOG ISIPISA U LOGOVIMA NA TESTOVIMA...
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="knjigaId")
    private Knjiga knjiga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="zaKorisnikId")
    private Korisnik zaKorisnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rezervisaoKorisnikId")
    private Korisnik korisnik;

    @Column(name="datumPodnosenja")
    private LocalDate datumPodnosenja;

    @Column(name="datumRezervacije")
    private LocalDate datumRezervacije;

    @Column(name="datumZatvaranja")
    private LocalDate datumZatvaranja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "razlogZatvaranja")
    private RazlogZatvaranjaRezervacije razlogZatvaranja;




}
