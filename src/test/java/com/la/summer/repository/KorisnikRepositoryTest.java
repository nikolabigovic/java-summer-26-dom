package com.la.summer.repository;

import com.la.summer.dto.query.KorisnikDto;
import com.la.summer.model.Korisnik;
import com.la.summer.model.Role;
import com.la.summer.projection.KorisnikProj;
import com.la.summer.record.KorisnikRecord;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Tuple;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class KorisnikRepositoryTest {

    @Autowired
    KorisnikRepository korisnikRepository;

//    Korisnik korisnik = new Korisnik("Petar","Petrovic","ppetrovic");

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

    @Test
    public void checkingJPQLSyntax() {
//        Korisnik korisnik = korisnikRepository.getByUsername("sradenovic");
//        log.info("Korisnik sa username-om: = {}", korisnik);
//        List<Korisnik> korisnikList = korisnikRepository.getByUsernameAndEmail("markovic@gmail.com", "sradenovic");
        List<Korisnik> korisnikList = korisnikRepository.getByAddress("es");
        for(Korisnik korisnik : korisnikList) {
            log.info("Korisnik-{}: {}", korisnik.getId(), korisnik);
        }
    }

    @Test
    public void checkingLazyFetchType() {
        List<Korisnik> korisnikList = korisnikRepository.getByRole("ROLE_ADMIN");
        for(Korisnik korisnik : korisnikList) {
            log.info("Korisnik-{}: {}", korisnik.getId(), korisnik);
        }
    }

    @Test
    public void testingInsertingData() {
        Korisnik korisnik = new Korisnik();
        korisnik.setId(4);
        korisnik.setIme("Petar");
        korisnik.setPrezime("Petrovic");
        korisnik.setUsername("ppetrovic3");
        //Demo za fault
//        List<Role> roleList = new ArrayList<>();
//        roleList.add(new Role());
//        korisnik.setRoleSet(roleList.stream().collect(Collectors.toSet()));
        //Good practice
//        korisnik.addNewRole(new Role());
        korisnikRepository.save(korisnik);
    }

    @Test
    public void testingUpdateData() {
        Optional<Korisnik> optionalKorisnik = korisnikRepository.findById(4);
        if(optionalKorisnik.isPresent()) {
            Korisnik korisnik = optionalKorisnik.get();
            korisnik.setEmail("nekaNova@yahoo.com");
            korisnik.setUsername("ppetrovic");
            korisnikRepository.save(korisnik);
        }
    }

    @Test
    public void testingDeleteData() {
        Korisnik korisnik = korisnikRepository.findById(5).orElseThrow(EntityNotFoundException::new);
//        korisnik.setId(4);
//        korisnikRepository.delete(korisnik);
        korisnikRepository.deleteById(5);
    }

    @Test
    @Transactional
    public void testingCustomUpdateData() {
        korisnikRepository.updateNameByUsername("sradenovic", "SStefan");
    }

    @Test
    public void testingDtoMapping() {
        KorisnikDto korisnikDto = korisnikRepository.getByUsernameDto("sradenovic");
        log.info("KorisnikDto: {}", korisnikDto);
    }

    @Test
    public void testingTupleMapping() {
        Tuple tuple = korisnikRepository.getByUsernameTuple("sradenovic");
        log.info("KorisnikTuple: {}", tuple);
        log.info("Korisnik username: {}", tuple.get("username").toString());
    }

    @Test
    public void testingProjectionMapping() {
        KorisnikProj korisnikProj = korisnikRepository.getByUsernameProjection("sradenovic");
        log.info("KorisnikProjection: {}", korisnikProj);
        log.info("Korisnik username: {}", korisnikProj.getUsername());
    }

    @Test
    public void testingRecordMapping() {
        KorisnikRecord korisnikRecord = korisnikRepository.getByUsernameRecord("sradenovic");
        log.info("KorisnikProjection: {}", korisnikRecord);
        log.info("Korisnik username: {}", korisnikRecord.username());
    }


    @Test
    @Transactional
    public void testingSQLProcedure() {
        String imePrezime = korisnikRepository.concatSQLProcedure("Stefan", "Radenovic");
        log.info("Ime i prezime: {}", imePrezime);
    }
}