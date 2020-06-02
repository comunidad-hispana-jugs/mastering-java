package org.medellinjug.mastering.constantvalues.exceptions.unchecked;

import java.util.Objects;

public class Calculator {
    public Integer sum(Integer a, Integer b) {
        if(Objects.isNull(a) || Objects.isNull(b)){
            throw new IllegalArgumentException("Wrong arguments");
        }

        return a + b;
    }

    public Double div(Integer a, Integer b) {
        if(Objects.isNull(a) || Objects.isNull(b)){
            throw new IllegalArgumentException("Wrong arguments");
        }

        return Double.valueOf(a / b);
    }
}
