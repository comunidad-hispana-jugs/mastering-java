package org.latamjugs.mastering.returning;

import java.util.Arrays;

public class Cat extends Pet {

    public Cat() {
        super();
        this.type = PetType.CAT;
        this.cost = 1500.00;
        this.attributes = Arrays.asList("unsociable", "vary hairy", "elegant");
        this.breed = "cat";
    }
}