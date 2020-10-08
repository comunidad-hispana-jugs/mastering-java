package org.latamjugs.mastering.objetosmutables;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class ValidaStringBuilderConcatTest {

    private final static Logger LOGGER = Logger.getLogger(  "StringValidaTest" );

    @Test
    private String validaTiempoStringBuilder() {
        System.setProperty("java.util.logging.SimpleFormatter.format", " %5$s %n");

        StringBuilder sbuilder = new StringBuilder();
        long iniciosb = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            sbuilder.append("Hola mundo cruel");
        }
        long finsb = System.currentTimeMillis();
        return "Tiempo del StringBuilder(10M): " + (finsb - iniciosb);
    }


}
