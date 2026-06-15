package com.la.summer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "korisnik")
@Getter
@Setter
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    private String password;

    @OneToOne(mappedBy = "korisnik")
    private KorisnikInfo korisnikInfo;

    @ManyToMany
    @JoinTable(name = "korisnik_role",
    joinColumns = @JoinColumn(name = "korisnik_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet = new HashSet<>();
}
