package org.medellinjug.mastering_java.avoid_checked_exceptions.checked;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ClientCalculatorTest {
    private ClientCalculator clientCalculator = new ClientCalculator();

    @Test
    void average_tryCatch() {
        try {
            Double average = clientCalculator.average(List.of(10, 20, 60, 70));

            assertEquals(40.0, average);
        } catch (InvalidArgumentsException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void average_throws() throws InvalidArgumentsException {
        Double average = clientCalculator.average(List.of(10, 20, 60, 70));

        assertEquals(40.0, average);
    }
}