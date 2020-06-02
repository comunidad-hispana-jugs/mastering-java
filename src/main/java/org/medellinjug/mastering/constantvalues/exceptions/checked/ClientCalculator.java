package org.medellinjug.mastering.constantvalues.exceptions.checked;

import java.util.List;

public class ClientCalculator {
    private final Calculator calculator;

    public ClientCalculator() {
        calculator = new Calculator();
    }

    public Double average(List<Integer> numbers) throws InvalidArgumentsException {
        if (numbers == null) {
            throw new InvalidArgumentsException("Wrong arguments");
        }

        Integer total = 0;

        for (int i = 0; i < numbers.size(); i++) {
            total = calculator.sum(numbers.get(i), total);
        }

        return calculator.div(total, numbers.size());
    }
}
