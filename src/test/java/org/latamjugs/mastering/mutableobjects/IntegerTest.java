package org.latamjugs.mastering.mutableobjects;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class IntegerTest {

    private final static Logger LOGGER = Logger.getLogger("StringTest" );

    @Test()
    public void testStrings() {
        System.setProperty("java.util.logging.SimpleFormatter.format", " %5$s %n");

        //toUPPERCASE
        Integer minumero = Integer.valueOf(123);
        LOGGER.info("--- integer");
        LOGGER.info("HasCode Integer" + minumero.hashCode() );
        minumero=minumero+1;
        LOGGER.info("HasCode Integer2: " + minumero.hashCode() );

    }
}
