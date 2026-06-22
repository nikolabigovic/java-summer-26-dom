package com.la.summer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "korisnik_info")
@Getter
@Setter
@ToString
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnik_id")
    @ToString.Exclude
    private Korisnik korisnik;
}
