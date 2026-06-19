package com.la.summer.repository;

import com.la.summer.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

    Korisnik findByUsername(String username);

    List<Korisnik> findByUsernameEndsWithOrEmail(String username, String email);

    List<Korisnik> findByKorisnikInfoAddressContaining(String adresa);

}
