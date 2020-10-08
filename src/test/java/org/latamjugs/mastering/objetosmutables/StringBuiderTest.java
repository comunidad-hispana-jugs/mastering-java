package org.latamjugs.mastering.objetosmutables;

import java.util.logging.Logger;

public class StringBuiderTest {

    private final static Logger LOGGER = Logger.getLogger("StringBuilderTest");


    @org.junit.Test()
    public void analizaStringBuilder() {
        System.setProperty("java.util.logging.SimpleFormatter.format", " %5$s %n");

        //
        StringBuilder sb = new StringBuilder("");
        LOGGER.warning("SB:Nueva Referencia2 : (" + sb + ") " + sb.hashCode());
        sb.append("Hola");
        LOGGER.warning("SB:Nueva Referencia2 : (" + sb + ") " + sb.hashCode());
        sb.append("Hola Mundo.");
        LOGGER.warning("SB:Nueva Referencia2 : (" + sb + ") " + sb.hashCode());

    }


}
