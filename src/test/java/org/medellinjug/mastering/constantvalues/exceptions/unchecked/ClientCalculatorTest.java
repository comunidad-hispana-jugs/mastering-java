package org.medellinjug.mastering.constantvalues.exceptions.unchecked;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ClientCalculatorTest {
    private ClientCalculator clientCalculator = new ClientCalculator();

    @Test
    void average() {
        Double average = clientCalculator.average(List.of(10, 20, 60, 70));

        assertEquals(40.0, average);
    }

    @Test
    void average_catch() {
        try {
            Double average = clientCalculator.average(null);

            assertEquals(40.0, average);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            fail();
        }
    }
}