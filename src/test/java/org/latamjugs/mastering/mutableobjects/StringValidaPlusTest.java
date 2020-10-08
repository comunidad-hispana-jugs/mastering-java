package org.latamjugs.mastering.mutableobjects;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class StringValidaPlusTest {
    private final static Logger LOGGER = Logger.getLogger(  "StringValidaTest" );


    @Test
    private void validaTiempoString() {
        String cadena = new String();
        long iniciosb = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            cadena += ("Hola mundo cruel");
        }
        long finsb = System.currentTimeMillis();
        LOGGER.info ("Tiempo agregando 10K a STRING: " + (finsb - iniciosb) );
    }
}
