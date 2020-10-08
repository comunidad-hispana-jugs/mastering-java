package org.latamjugs.mastering.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * @author ecabrerar
 * @date   Oct 05, 2020
 */
public class TemporadaCiclonica implements TemporalQuery<Boolean>{

	@Override
	public Boolean queryFrom(TemporalAccessor temporal) {

		LocalDate fecha = LocalDate.from(temporal);

		MonthDay primeroJulio = MonthDay.of(Month.JUNE.getValue(), 1);
		MonthDay trentaNoviembre = MonthDay.of(Month.NOVEMBER.getValue(), 30);

		return fecha.isAfter(primeroJulio.atYear(fecha.getYear())) && fecha.isBefore(trentaNoviembre.atYear(fecha.getYear()));
	}

}
