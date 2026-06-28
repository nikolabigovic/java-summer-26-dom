package com.la.summer.repository;

import com.la.summer.model.Korisnik;
import com.la.summer.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer> {

    List <Rezervacija> findByZaKorisnikId(Integer zaKorisnik);

    List <Rezervacija> findByKnjigaId(Integer knjigaId);

    Optional <Rezervacija> findById(Integer id);

    void deleteById(Integer id);

    List<Rezervacija> findByDatumPodnosenjaAndKnjigaId(LocalDate datumPodnosenja, Integer knjigaId);



}
