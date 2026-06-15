package com.la.summer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ime_prezime", length = 300)
    private String imePrezime;

    @Column(name = "biografija", length = 1000)
    private String biografija;

    @OneToMany(mappedBy = "autor")
    private List<Knjiga> knjigaList = new ArrayList<>();

}