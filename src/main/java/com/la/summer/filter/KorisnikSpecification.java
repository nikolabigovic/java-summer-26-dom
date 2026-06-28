package com.la.summer.filter;

import com.la.summer.dto.query.KorisnikFilter;
import com.la.summer.model.Korisnik;
import com.la.summer.model.KorisnikInfo;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class KorisnikSpecification implements Specification<Korisnik> {

    private KorisnikFilter korisnikFilter;

    public KorisnikSpecification(KorisnikFilter korisnikFilter) {
        this.korisnikFilter = korisnikFilter;
    }

    @Override
    public @Nullable Predicate toPredicate(Root<Korisnik> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();

        checkEmail(korisnikFilter.getEmail(), predicateList, criteriaBuilder, root);
        checkName(korisnikFilter.getName(), predicateList, criteriaBuilder, root);
//        checkSurname(korisnikFilter.getSurname());
//        checkUsername(korisnikFilter.getUsername());
        checkAge(korisnikFilter.getAge(), predicateList, criteriaBuilder, root);
        return criteriaBuilder.and(predicateList);
    }

    private void checkEmail(String email, List<Predicate> predicateList, CriteriaBuilder criteriaBuilder, Root root) {
        if(!StringUtils.isEmpty(email) && !StringUtils.isBlank(email)) {
           Predicate predicate = criteriaBuilder.like(root.get("email"), email); //where email = :email
           predicateList.add(predicate);
        }
    }

    private void checkName(String name, List<Predicate> predicateList, CriteriaBuilder criteriaBuilder, Root root) {
        if(!name.toLowerCase().contains("f**k")) {
            Predicate predicate = criteriaBuilder.equal(root.get("ime"), name);
            predicateList.add(predicate);
        }
    }

    private void checkAge(Integer age, List<Predicate> predicateList, CriteriaBuilder criteriaBuilder, Root root) {
            Join<Korisnik, KorisnikInfo> infoJoin = root.join("korisnik");
            Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(infoJoin.get("age"), age);
            predicateList.add(predicate);
    }


}
