package org.medellinjug.mastering.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoxGenericClassTest {


	@Test
	void testSetT() {
		BoxGenericClass <Integer> intObj = new BoxGenericClass<>();
		intObj.setT(10);
		
		Assertions.assertEquals(10, intObj.getT());
	}

}
