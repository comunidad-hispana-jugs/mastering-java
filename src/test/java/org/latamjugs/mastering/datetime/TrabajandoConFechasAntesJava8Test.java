package org.latamjugs.mastering.datetime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ecabrerar
 * @since Oct 7, 2020
 */
class TrabajandoConFechasAntesJava8Test {
	private static final Logger logger = Logger.getLogger(TrabajandoConFechasAntesJava8Test.class.getName());

	@Test
	void comparar_dos_fecha_en_java() {
		// 21 de agosto de 2016
		Calendar fechaJJOO = Calendar.getInstance();
		fechaJJOO.set(Calendar.YEAR, 2016);
		fechaJJOO.set(Calendar.MONTH, 8);
		fechaJJOO.set(Calendar.DAY_OF_MONTH, 21);

		Calendar fechaActual = Calendar.getInstance();

		Assertions.assertTrue(fechaActual.after(fechaJJOO));

	}

	@Test
	void comparar_dos_fecha_en_java_con_apachecommons() {
		// 21 de agosto de 2016
		Calendar fechaJJOO = Calendar.getInstance();
		fechaJJOO.set(Calendar.YEAR, 2016);
		fechaJJOO.set(Calendar.MONTH, 8);
		fechaJJOO.set(Calendar.DAY_OF_MONTH, 21);

		Calendar fechaActual = Calendar.getInstance();

		int valor = DateUtils.truncatedCompareTo(fechaJJOO, fechaActual, Calendar.MONTH);

		logger.info(DateUtils.truncate(fechaJJOO, Calendar.MONTH).toString());

		logger.info(DateUtils.truncate(fechaActual, Calendar.MONTH).toString());

		Assertions.assertTrue(valor <= 0);
	}

	@Test
	void comparar_dos_fecha_en_java_con_joda() {
		DateTime fechaJJOO = new DateTime(2016, 8, 21, 0, 0, GregorianChronology.getInstance());

		DateTime fechaActual = new DateTime();

		Assertions.assertTrue(fechaActual.isAfter(fechaJJOO));

	}

	@Test
	void conversion_de_fecha_en_java() throws ParseException {

		String fechaJJOOString = "August 21, 2016";

		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT-0600"));
		Date fechaJJOOAsDate = formatter.parse(fechaJJOOString);

		assertEquals(1471759200000l, fechaJJOOAsDate.getTime());

	}

	@Test
	void conversion_de_fecha_en_java_con_joda() throws ParseException {

		String fechaJJOOString = "August 21, 2016";

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM dd, yyyy")
				.withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT-0600")));

		DateTime fechaJJOOAsDate = fmt.parseDateTime(fechaJJOOString);

		assertEquals(1471759200000l, fechaJJOOAsDate.getMillis());

	}

	@Test
	void conversion_de_fecha_en_java_con_apachecommons() throws ParseException {
		String fechaJJOOString = "August 21, 2016";

		Date fechaJJOOAsDate = DateUtils.parseDate(fechaJJOOString, "MMMM dd, yyyy");

		assertEquals(1471752000000l, fechaJJOOAsDate.getTime());
	}

}
