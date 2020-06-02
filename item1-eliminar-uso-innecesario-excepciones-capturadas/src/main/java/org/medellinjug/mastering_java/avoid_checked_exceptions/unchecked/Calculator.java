package org.medellinjug.mastering_java.avoid_checked_exceptions.unchecked;

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
