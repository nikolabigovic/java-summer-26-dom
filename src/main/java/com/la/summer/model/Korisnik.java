package com.la.summer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;

import java.util.HashSet;
import java.util.Set;

//@DynamicUpdate
@Entity
@Table(name = "korisnik")
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedStoredProcedureQuery(name = "imePrezime", procedureName = "concat_ime_i_prezime", parameters = {
        @StoredProcedureParameter(name = "name", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "surname", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "imePrezime", mode = ParameterMode.OUT, type = String.class),
}
 )
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    private String password;

    @OneToOne(mappedBy = "korisnik", fetch = FetchType.LAZY)
    private KorisnikInfo korisnikInfo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "korisnik_role",
    joinColumns = @JoinColumn(name = "korisnik_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet = new HashSet<>();

    public void addNewRole(Role role) {
        this.roleSet.add(role);
    }

    public void removeNewRole(Role role) {
        this.roleSet.remove(role);
    }
}
