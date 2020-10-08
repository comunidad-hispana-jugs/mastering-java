package org.latamjugs.mastering.mutableobjects;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class EstudianteTest {


    private final static Logger LOGGER = Logger.getLogger("EstudianteTest");

    @Test
    public void pruebaEstudiante(){
        System.setProperty("java.util.logging.SimpleFormatter.format", " %5$s %n");

        //Definiendo Edad ("Siglo en el que vive") o Generación Y
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1992);
        //
        Estudiante student = new Estudiante(1, "ALEX", age);
        LOGGER.info( "Estudiante edad es antes modification = " + student.getAge().getYear() );
        LOGGER.info( "Modificando Edad con nuevo valor:  1993");
        age.setYear(1993);
        LOGGER.info( "Estudiante esdad es despues modification = " + student.getAge().getYear() );
        //
        LOGGER.info("");
        LOGGER.info( ":: immutable");
        LOGGER.info( "=================== ");
        //

        //
        EstudianteInmutable studentImutable = new EstudianteInmutable(1, "JOSE", age);
        LOGGER.info( "Estudiante "  + studentImutable.getName() + " edad es antes modification = " + studentImutable.getAge().getYear());
        LOGGER.info( "Modificando Edad con nuevo valor:  2000");
        age.setYear(2000);
        LOGGER.info( "Estudiante" + studentImutable.getName() + " edad es despues modification = " + studentImutable.getAge().getYear());
        LOGGER.info( ".");
        //
        //
        studentImutable.getAge().setYear(1993);
        LOGGER.info( "Estudiante" + studentImutable.getName() + " edad es despues modification = " + studentImutable.getAge().getYear() ) ;

    }
}
