package org.latamjugs.mastering.objetosmutables;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class ValidaStringBufferingConcatTest {

    private final static Logger LOGGER = Logger.getLogger(  "StringValidaTest" );

    @Test
    public void validaTimeStringBuffer() {
        System.setProperty("java.util.logging.SimpleFormatter.format", " %5$s %n");

        StringBuffer sbuffer = new StringBuffer();
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            sbuffer.append("Hola mundo cruel");
        }
        long fin = System.currentTimeMillis();
        LOGGER.info("Tiempo del StringBuffer(10M): " + (fin - inicio) );
        //
        LOGGER.info("//");
        StringBuilder sbuilder = new StringBuilder();
        long iniciosb = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            sbuilder.append("Hola mundo cruel");
        }
        long finsb = System.currentTimeMillis();
        LOGGER.info( "Tiempo del StringBuilder(10M): " + (finsb - iniciosb) ) ;
    }


}
