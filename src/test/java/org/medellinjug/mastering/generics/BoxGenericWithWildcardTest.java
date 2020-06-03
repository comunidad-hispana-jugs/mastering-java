package org.medellinjug.mastering.generics;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoxGenericWithWildcardTest {

	@Test
	void testSum() {
		
		List<Integer> ints = Arrays.asList(1,2,3,4,5);
		
	    Number total =	BoxGenericWithWildcard.sum(ints);
		
		Assertions.assertEquals(15, total.intValue());
		
		
		   List<Double> doubles = Arrays.asList(1.5d,2d,3d);
		   
		   Assertions.assertEquals(6.5d, BoxGenericWithWildcard.sum(doubles).doubleValue());
		   
		   List<String> strings = Arrays.asList("1","2");
		   
		//   BoxGenericWithWildcard.sum(strings);
		   //This will give compilation error as :: The method sum(List<? extends Number>) in the type BoxGenericWithWildcard is not applicable for the arguments (List<String>)
	}

}
