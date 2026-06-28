package com.la.summer.repository;

import com.la.summer.dto.query.KorisnikDto;
import com.la.summer.filter.KorisnikSpecification;
import com.la.summer.model.Korisnik;
import com.la.summer.projection.KorisnikProj;
import com.la.summer.record.KorisnikRecord;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer>, JpaSpecificationExecutor<Korisnik> {

    //JPA Method Query
    Korisnik findByUsername(String username);

    List<Korisnik> findByUsernameEndsWithOrEmail(String username, String email);

    List<Korisnik> findByKorisnikInfoAddressContaining(String adresa);

    //JPQL
    @Query("select k from Korisnik k where k.username = :username")
    Korisnik getByUsername(String username);

//    @Query(value = "SELECT k FROM Korisnik k WHERE k.username = ?2 AND k.email = ?1")
    @Query(value = "SELECT k FROM Korisnik k WHERE k.username = :username OR k.email = :eAdresa")
    List<Korisnik> getByUsernameAndEmail(@Param("eAdresa") String email,@Param("username") String username);

//    @Query("select k from Korisnik k join k.korisnikInfo ki where ki.address like concat('%',:name, '%')")
    @Query("select k from Korisnik k join k.korisnikInfo ki where ki.address like %:name%")
    List<Korisnik> getByAddress(@Param("name") String address);

    //select * from korisnik join korisnik_role .... where role_code = ?
    @Query("select k from Korisnik k join fetch k.roleSet r where r.roleCode = :roleCode")
    List<Korisnik> getByRole(String roleCode);

//    @Query(value = "update korisnik set name = :name where username = :username ", nativeQuery = true)
    @Query("update Korisnik k set k.ime = :name where k.username = :username")
    @Modifying
    void updateNameByUsername(String username, String name);


    //Mapiranje na DTO
    @Query("select new com.la.summer.dto.query.KorisnikDto(k.email, k.username, k.password) from Korisnik k where k.username = :username")
    KorisnikDto getByUsernameDto(String username);

//    @Query("select k.email as email, k.username as username, k.password as password from Korisnik k where k.username = :username")
//    KorisnikDto getByUsernameDtoNoNew(String username);

    //Tuple
    @Query("select k.email as email, k.username as username, k.password as password from Korisnik k where k.username = :username")
    Tuple getByUsernameTuple(String username);

    //Interface based projection
    @Query("select k.email as email, k.username as username, k.password as password from Korisnik k where k.username = :username")
    KorisnikProj getByUsernameProjection(String username);

    //Records
    @Query("select k.email as email, k.username as username, k.password as password from Korisnik k where k.username = :username")
    KorisnikRecord getByUsernameRecord(String username);


    //SQL Procedure
    @Procedure(name = "imePrezime")
    String concatSQLProcedure(@Param("name") String ime, @Param("surname") String prezime);

}
