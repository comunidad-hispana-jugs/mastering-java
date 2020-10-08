package org.latamjugs.mastering.objetosmutables;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class DoubleTest {

    private final static Logger LOGGER = Logger.getLogger("StringTest" );

    @Test()
    public void testStrings() {
        System.setProperty("java.util.logging.SimpleFormatter.format", " %5$s %n");

        //toUPPERCASE
        Double minumero = Double.valueOf(123);
        LOGGER.info("--- Double");
        LOGGER.info("HasCode Double: " + minumero.hashCode() );
        minumero=minumero+1;
        LOGGER.info("HasCode Double2: " + minumero.hashCode() );

    }
}
