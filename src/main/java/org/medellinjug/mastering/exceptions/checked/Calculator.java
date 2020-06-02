package org.medellinjug.mastering.exceptions.checked;

public class Calculator {
    public Integer sum(Integer a, Integer b) throws InvalidArgumentsException {
        if (a == null || b == null) {
            throw new InvalidArgumentsException("Wrong arguments");
        }

        return a + b;
    }

    public Double div(Integer a, Integer b) throws InvalidArgumentsException {
        if (a == null || b == null) {
            throw new InvalidArgumentsException("Wrong arguments");
        }

        return Double.valueOf(a / b);
    }
}
