package org.medellinjug.mastering.exceptions.unchecked;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClientCalculatorTest {
    private ClientCalculator clientCalculator = new ClientCalculator();

    @Test
    void average() {
        Double average = clientCalculator.average(List.of(10, 20, 60, 70));

        assertEquals(40.0, average);
    }

    @Test
    void average_catch() {
    	
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
       
            Double average = clientCalculator.average(null); //This will give IllegalArgumentException

            assertEquals(40.0, average);
    	});
    }
}