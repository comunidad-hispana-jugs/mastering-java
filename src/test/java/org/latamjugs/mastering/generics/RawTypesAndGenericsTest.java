package org.latamjugs.mastering.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RawTypesAndGenericsTest {

	@Test()
	public void testRawType() {
		List lista = new ArrayList();
		lista.add(" Medillin JUG");
		lista.add("Java is 25");
		lista.add(1000L);
		
		Assertions.assertEquals(3,lista.size());
		
		Exception thrown = Assertions.assertThrows(ClassCastException.class,()->{
		
			for (int i = 0; i < lista.size(); i++) {
				String array_element = (String) lista.get(i);
				
				System.out.println(array_element);			
			}		
	   });
		
		Assertions.assertTrue(thrown.getMessage().contains("class java.lang.Long cannot be cast"));
	}
		
		@Test
		public void testGenericType() {
			List<String> lista = new ArrayList<>();
			lista.add(" Medillin JUG");
			lista.add("Java is 25");
			
			for (int i = 0; i < lista.size(); i++) {
				String array_element =  lista.get(i);
				
				System.out.println(array_element);
			}	
	
			Assertions.assertEquals(2,lista.size());
		}
		
		@Test
		public void testGeneric2() {
			List<IProcesador> procesador = new ArrayList<IProcesador>();
			procesador.add(new ProcesadorTexto());
			procesador.add(new OtroProcesador());
			
			for (IProcesador iProcesador : procesador) {
				iProcesador.procesar();
			}
			
			Assertions.assertEquals(2,procesador.size());
		}
		
		@Test
		public void testGenericTypeWithInteger() {
			List<Integer> ints = Arrays.asList(1,2,3,4,5);
			
		    Double resultado = this.sum(ints);
			
		    Assertions.assertEquals(15, resultado);
		    
			System.out.println(" resultado "+(Double.valueOf(resultado)));
			
		    List<Double> doubles = Arrays.asList(1.5d,2d,3d);
			   
			Double resultado2 = this.sum(doubles);
			
		    Assertions.assertEquals(6.5d, resultado2);			
			

			System.out.println(" resultado "+(Double.valueOf(resultado2)));

			 List<Number> numbers = new ArrayList<>();
			 numbers.add(100);
			 numbers.add(999.99d);
			 numbers.add(10000L);
			 
		    Assertions.assertEquals(11099.99d, this.sum(numbers));			

		}
		
		private Double sum(List<? extends Number> numbers) {
		  return numbers.stream().mapToDouble(number -> number.doubleValue()).sum();	
		}
}
