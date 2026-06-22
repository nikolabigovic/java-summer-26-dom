package com.la.summer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role_code", length = 100)
    private String roleCode;

    @Column(name = "opis", length = 300)
    private String opis;

    @ManyToMany(mappedBy = "roleSet")
    private Set<Korisnik> korisnikSet = new HashSet<>();
}