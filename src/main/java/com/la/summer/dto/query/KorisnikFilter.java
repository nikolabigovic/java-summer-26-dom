package com.la.summer.dto.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KorisnikFilter {

    private String email;
    private String name;
    private String surname;
    private String username;
    private Integer age;
}
