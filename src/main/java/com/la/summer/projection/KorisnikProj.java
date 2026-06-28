package com.la.summer.projection;


public interface KorisnikProj {

    String getEmail();
    String getUsername();
    String getPassword();

    default String print() {
        return "username: " + getUsername() +
                "email: " + getEmail() +
                "password: " + getPassword();

    }

}
