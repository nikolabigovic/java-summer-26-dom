package com.la.summer.service;

import com.la.summer.dto.query.KorisnikFilter;
import com.la.summer.filter.KorisnikSpecification;
import com.la.summer.model.Korisnik;
import com.la.summer.repository.KorisnikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KorisnikService {

    private KorisnikRepository korisnikRepository;

    public List<Korisnik> getByFilter(KorisnikFilter korisnikFilter) {
        Specification<Korisnik> korisnikSpecification = new KorisnikSpecification(korisnikFilter);
        korisnikRepository.findAll(korisnikSpecification);
        return null;
    }
}
