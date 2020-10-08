package org.latamjugs.mastering.mutableobjects;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

public class StringTest {

    private final static Logger LOGGER = Logger.getLogger("StringTest" );

    @Test()
    public void testStrings() {
        System.setProperty("java.util.logging.SimpleFormatter.format", " %5$s %n");


        String miCadena = "";
        String miCadena2 = "Hola";
        LOGGER.info("Referencia : (" + miCadena + ") " + miCadena.hashCode());
        LOGGER.info("Referencia2 : (" + miCadena2 + ") " + miCadena2.hashCode());
        miCadena2 = "Hola Mundo";
        LOGGER.info("Nueva Referencia2 : (" + miCadena2 + ") " + miCadena2.hashCode());

        miCadena2 = "Hola Mundo".concat(".");
        LOGGER.info("Nueva Referencia2 : (" + miCadena2 + ") " + miCadena2.hashCode());

        LOGGER.info("");
        LOGGER.info("HasCode de Uppercase " + miCadena2.toUpperCase().hashCode() );
        //toUPPERCASE
        LOGGER.info("HasCode de Uppercase " + miCadena2.hashCode() );

    }

    @Test
    public void lista(){

        Estudiante student1 = new Estudiante(1, "ALEX",  new Age());
        Estudiante student2 = new Estudiante(1, "ALEX",  new Age());
        Estudiante student3 = new Estudiante(1, "ALEX",   new Age());

        List<Estudiante> miList = List.of( student1, student2, student3);
        //udpate value
        miList.get(2).setName("batman");

        LOGGER.info( miList.toString() );

    }
}
