package com.la.summer.contoller;

import com.la.summer.dto.query.KorisnikFilter;
import com.la.summer.model.Korisnik;
import com.la.summer.service.KorisnikService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/korisnik")
@RequiredArgsConstructor
public class KorisnikController {

    private final KorisnikService korisnikService;

    @PostMapping("filter")
    public ResponseEntity<List<Korisnik>> getByFilter(@RequestBody KorisnikFilter korisnikFilter) {
        korisnikService.getByFilter(korisnikFilter);
        return null;
    }
}
