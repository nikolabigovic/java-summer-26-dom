package com.la.summer.repository;

import com.la.summer.model.Rezervacija;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class RezervacijaRepositoryDomaci3Test {

    @Autowired
    private RezervacijaRepository rezervacijaRepository;

    @Test
    void findByZaKorisnikId() {
        List<Rezervacija> lista=rezervacijaRepository.findByZaKorisnikId(1);
    }

    @Test
    void findByKnjigaId() {
        List <Rezervacija> lista=rezervacijaRepository.findByKnjigaId(2);
        for (Rezervacija rezervacija:lista){
            log.info("lista={}",lista);}
    }

    @Test
    @Transactional
    void findById() {
        Rezervacija rezervacija=rezervacijaRepository.findById(1).get();
        log.info("rezervacija={}",rezervacija);
    }

    @Test
    void deleteById() {
        rezervacijaRepository.deleteById(1);
    }

    @Test
    void findByDatumPodnosenjaAndKnjigaId() {
        List<Rezervacija> lista = rezervacijaRepository.findByDatumPodnosenjaAndKnjigaId(LocalDate.of(2010, 6, 20),2);
        for(Rezervacija rezervacija:lista){
            log.info("lista={}",lista);
        }
    }
}