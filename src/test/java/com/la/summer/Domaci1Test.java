package com.la.summer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class Domaci1Test {

    @Autowired
    private Domaci1 domaci1;

    @Test
    public void pisanjeConfig(){
    //preko @value
    domaci1.stampanjeConfig();
    //preko config properties
    domaci1.stampanjeConfig2();

    //preko env
    domaci1.stampanjeConfig3();


    }
}