package com.la.summer.repository;

import com.la.summer.model.Korisnik;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class KorisnikRepositoryTest {

    @Autowired
    KorisnikRepository korisnikRepository;

    @Test
    public void checkIfReturnKorisnikStefan() {
        Korisnik korisnik = korisnikRepository.findByUsername("sradenovic");
        log.info("Korisnik sa username-om: = {}", korisnik);
    }

//    @Test
//    public void checkingJpaMetodQuery() {
//        List<Korisnik> korisnikList = korisnikRepository.findByUsernameEndsWithOrEmail("ed", "markovic@gmail.com");
//        for(Korisnik korisnik : korisnikList) {
//            log.info("Korisnik-{}: {}", korisnik.getId(), korisnik);
//        }
//    }

    @Test
    public void checkingJpaMetodQuery() {
        List<Korisnik> korisnikList = korisnikRepository.findByKorisnikInfoAddressContaining("test");
        for(Korisnik korisnik : korisnikList) {
            log.info("Korisnik-{}: {}", korisnik.getId(), korisnik);
        }
    }

    @Test
    public void demoForNativeJpaRepository() {
        korisnikRepository.findById(1);
        korisnikRepository.findAll();
    }

}