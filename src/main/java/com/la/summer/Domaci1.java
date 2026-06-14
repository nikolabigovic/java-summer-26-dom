package com.la.summer;

import com.la.summer.config.Domaci1Config;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Domaci1 {

    private Logger log= LoggerFactory.getLogger(Domaci1.class);

    @Autowired
    private Domaci1Config domaci1Config;

    @Autowired
    private Environment env;

        @Value("${domaci1.par1}")
        private String par1;

        @Value("${domaci1.par2}")
        private String par2;

        @Value("${domaci1.par3}")
        private int par3;

        @Value("${domaci1.par4}")
        private boolean par4;

    public void stampanjeConfig(){
        log.info("ispis za par1: {}", par1);
        log.info("ispis za par2: {}", par2);
        log.info("ispis za par3: {}", par3);
        log.info("ispis za par4: {}", par4);


    }

    public void stampanjeConfig2(){
        log.info("ispis za par1: {}", domaci1Config.getPar1());
        log.info("ispis za par2: {}", domaci1Config.getPar2());
        log.info("ispis za par3: {}", domaci1Config.getPar3());
        log.info("ispis za par4: {}", domaci1Config.isPar4());
    }

    public void stampanjeConfig3(){
        log.info("ispis za par1: {}",env.getProperty("domaci1.par1"));
        log.info("ispis za par2: {}",env.getProperty("domaci1.par2"));
        log.info("ispis za par3: {}",env.getProperty("domaci1.par3"));
        log.info("ispis za par4: {}",env.getProperty("domaci1.par4"));

    }

}
