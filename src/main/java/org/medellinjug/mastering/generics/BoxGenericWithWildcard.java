
package org.medellinjug.mastering.generics;

import java.util.List;

/**
 * @author ecabrerar
 * @date Jun 3, 2020
 *
 */
public class BoxGenericWithWildcard {
	
	private BoxGenericWithWildcard() { }

	public static Number sum(List<? extends Number> numbers) {

		return numbers.stream().mapToDouble(num -> num.doubleValue()).sum();
	}
}
