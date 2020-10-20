package org.latamjugs.mastering.mutableobjects;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class StringValidaConcatTest {

    private final static Logger LOGGER = Logger.getLogger("ValidaStringConcatTest" );

    @Test
    public void validaTiempoStringConcat() {
        System.setProperty("java.util.logging.SimpleFormatter.format", " %5$s %n");

        String cadena = new String();
        long iniciosb = System.currentTimeMillis();
        for (int i = 0; i < 40000; i++) {
            //cadena += "Hola mundo cruel";
            cadena = cadena.concat("Hola mundo cruel");
        }

        long finsb = System.currentTimeMillis();

        LOGGER.info( "Tiempo agregando 40K a STRING: " + (finsb - iniciosb) );
    }

}
