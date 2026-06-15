package com.la.summer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;

@Entity
@Table(name = "korisnik_info")
@Getter
@Setter
public class KorisnikInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "adresa")
    private String address;

    @Column(name = "br_telefona")
    private String mobile;

    @Column(name = "godine")
    private Integer age;

    @Column(name = "datum_kreiranja")
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;
}
