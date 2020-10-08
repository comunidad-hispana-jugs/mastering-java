
package org.latamjugs.mastering.datetime;

import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.List;


/**
 *
 * @author ecabrerar
 * @date Oct 05, 2020
 */
public class DiasFestivosRD implements TemporalQuery<Boolean>{

     static List<MonthDay> DIAS_FESTIVOS =  List. of(
	            MonthDay.of(Month.JANUARY, 1), // Año Nuevo
	            MonthDay.of(Month.JANUARY, 6), // Día Santos Reyes
	            MonthDay.of(Month.JANUARY, 21), // Día de la Altagracia
	            MonthDay.of(Month.JANUARY, 26), // Día del Natalicio de Duarte
	            MonthDay.of(Month.FEBRUARY, 27), // Día Independecia Nacional
	            MonthDay.of(Month.MAY, 1),      //Día Trabajador
	            MonthDay.of(Month.AUGUST, 16),  //Día Restauración
	            MonthDay.of(Month.SEPTEMBER, 24), //Día de las Mercedes
	            MonthDay.of(Month.NOVEMBER, 6), //Día Constitución
	            MonthDay.of(Month.DECEMBER, 25) //Día de Navidad

	    );


    @Override
    public Boolean queryFrom(TemporalAccessor date) {
       MonthDay diaMesActual = MonthDay.from(date);

        return DIAS_FESTIVOS.contains(diaMesActual);
    }

}
