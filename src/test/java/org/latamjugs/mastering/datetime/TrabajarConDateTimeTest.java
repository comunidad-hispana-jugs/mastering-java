package org.latamjugs.mastering.datetime;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 *
 * @author ecabrerar
 * 
 */
class TrabajarConDateTimeTest {

	private static final Logger logger = Logger.getLogger(TrabajarConDateTimeTest.class.getName());

	@Test
	 void comparar_dos_fecha_en_java8() {
		 //21 de agosto de 2016
		
		LocalDate fechaJJOO = LocalDate.of(2016, 8, 21);
		LocalDate fechaActual = LocalDate.now();
		
		Assertions.assertTrue(fechaActual.isAfter(fechaJJOO));
		
	 }
	
	@Test
	void trabajando_con_fecha_y_tiempo() {
	    LocalDateTime s4LatamTalks = LocalDateTime.of(2020, 10, 7, 7, 00);
	    LocalDateTime s4LatamTalksParsed = LocalDateTime.parse("2020-10-07T07:00");
       
	    
	    Assertions.assertEquals(s4LatamTalks, s4LatamTalksParsed);
	}

	@Test
	void obtener_zonahoraria(){
		ZoneId zone = ZoneId.systemDefault();
		logger.info(zone.toString());
		
		//ZoneId zoneAmerica = ZoneId.of("America/Santo_Domingo");
		ZoneId zoneBerlin = ZoneId.of("Europe/Berlin");
		
		assertNotEquals(zone, zoneBerlin);
		
	}
	
	@Test
	void trabajando_con_zona_horaria() {
	    ZoneId.getAvailableZoneIds()
	    .stream()
	    .forEach(zoneid -> System.out.println(zoneid));
		
		LocalDateTime s4LatamTalks = LocalDateTime.of(2020, 10, 7, 7, 00);
		ZonedDateTime zonedDateTimeLocal = ZonedDateTime.of(s4LatamTalks, ZoneId.of("America/Santo_Domingo"));
		
		
	    ZoneId zoneBA = ZoneId.of("America/Buenos_Aires");
		
	    ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.of(2020, 10, 7, 8, 00), zoneBA);
	    
	    logger.info(zonedDateTime.toString());
	    
	    
	    logger.info(zonedDateTimeLocal.toString());   
	        
	   
		
	}
	
	@Test
	 void conversion_de_fecha_en_java_java8 () {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		
		String fechaJJOOString = "August 21, 2016";
		
		LocalDate fechaJJOOAsDate = LocalDate.parse(fechaJJOOString, formatter);
	    assertEquals(2016, fechaJJOOAsDate.getYear());

		
	 }
	
	@Test
	void compactibilidad_con_date_y_calendar() {
		Calendar fechaJJOO = Calendar.getInstance();
		fechaJJOO.set(Calendar.YEAR, 2016);
		fechaJJOO.set(Calendar.MONTH, 8);
		fechaJJOO.set(Calendar.DAY_OF_MONTH, 21);
		
				
		Date fecha =fechaJJOO.getTime();
		
		LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
		
		
	}

	
	
    @Test
    void calcular_diferencia_entre_dos_fecha_java8_usando_period() {

	    LocalDate sinceBarCamp2013 = LocalDate.of(2013, Month.NOVEMBER, 16);
	    LocalDate date = LocalDate.of(2015, Month.NOVEMBER, 28);

	    Period betweenDates = Period.between(sinceBarCamp2013, date);

	    int diffInDays = betweenDates.getDays();
	    int diffInMonths = betweenDates.getMonths();
	    int diffInYears = betweenDates.getYears();

	    logger.info(String.format("days %d months %d years %d", diffInDays,diffInMonths,diffInYears));

	    assertEquals(12,diffInDays);
        assertTrue(diffInMonths >= 0);
        assertEquals(2,diffInYears);
	}

    @Test
     void es_festivo_el_26_enero_2016() {

	    LocalDate date = LocalDate.of(2016, Month.JANUARY, 26);

	    Boolean isHoliday = date.query(new DiasFestivosRD());

	    assertTrue(isHoliday);
	}


    @Test
     void obtener_cantidad_dias_que_tienes_un_mes() {

	    LocalDate date = LocalDate.of(2015, Month.NOVEMBER, 01);

	    int length = date.getMonth().length(true);

	    Assertions.assertEquals(30, length);

   }

   @Test
    void cantidad_dias_que_tienes_un_mes_usando_lengthOfMonth() {

	    LocalDate date = LocalDate.of(2015, Month.MARCH, 01);

	    int length2 = date.lengthOfMonth();

	    assertEquals(31, length2);
   }


   @Test
    void es_antes_de_la_temporada_ciclonica () {

    LocalDate date = LocalDate.of(2017, Month.JANUARY, 02);

       Boolean esTemporadaCiclonica = date.query(new TemporadaCiclonica());

      assertFalse(esTemporadaCiclonica);
   }

   @Test
    void es_durante_la_temporada_ciclonica () {

       LocalDate date = LocalDate.of(2017, Month.JUNE, 30);

       Boolean esTemporadaCiclonica = date.query(new TemporadaCiclonica());

       assertTrue(esTemporadaCiclonica);
   }

   @Test
   void es_despues_de_la_temporada_ciclonica () {

       LocalDate date = LocalDate.of(2017, Month.DECEMBER, 30);

       Boolean esTemporadaCiclonica = date.query(new TemporadaCiclonica());

       assertFalse(esTemporadaCiclonica);
   }

   @Test
   void comparar_fecha() {
	   LocalDate barCampSTI2013 = LocalDate.of(2013, Month.NOVEMBER, 16);

	   LocalDate today = LocalDate.now();
	   LocalDate javaOne2013 = LocalDate.of(2013, Month.SEPTEMBER, 18);

	   assertTrue(today.isAfter(barCampSTI2013));

	   assertTrue(javaOne2013.isBefore(barCampSTI2013));

   }

   @Test
   void dias_entre_dos_fechas(){
	   LocalDate startDate = LocalDate.now().minusDays(2);
	   LocalDate endDate = LocalDate.now();
	  
	   
	   long days1 =  Period.between(startDate, endDate).getDays();

	   assertEquals(2, days1);

	   LocalDate barCampSTI2013 = LocalDate.of(2013, Month.NOVEMBER, 16);

	   LocalDate javaOne2013 = LocalDate.of(2013, Month.SEPTEMBER, 18);

	   long days = ChronoUnit.DAYS.between(javaOne2013, barCampSTI2013);

	   logger.info(String.format("day  %d", days));

	   assertEquals(59, days);
   }


   @Test
   void meses_entre_dos_fechas(){

	   LocalDate barCampSTI2013 = LocalDate.of(2013, Month.NOVEMBER, 16);

	   LocalDate javaOne2013 = LocalDate.of(2013, Month.SEPTEMBER, 18);

	   long months = ChronoUnit.MONTHS.between(javaOne2013, barCampSTI2013);

	   logger.info(String.format("months  %d", months));

	   assertEquals(1, months);
   }
   
   @Test
    void encontrar_ultimo_dia_de_un_mes() {

       LocalDate fecha = LocalDate.of(2020, Month.OCTOBER, 1);

       LocalDate ultimoDiaMes = fecha.with(TemporalAdjusters.lastDayOfMonth());

       assertEquals(LocalDate.of(2020, Month.OCTOBER, 28), ultimoDiaMes);
   }

}
