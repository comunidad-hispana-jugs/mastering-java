package org.medellinjug.mastering.returning;

import java.util.Arrays;

public class Dog extends Pet {

    public Dog() {
        super();
        this.cost = 1000.00;
        this.type = PetType.DOG;
        attributes = Arrays.asList("pretty", "hairy", "loyal");
    }

    public Dog(String breed) {
        this();
        this.breed = breed;
    }

    private Dog(Pet pet) {
        this.breed = pet.breed;
        this.attributes = pet.attributes;
        this.cost = pet.cost;
        this.code = pet.code;
        this.type = PetType.DOG;
    }

    @Override
    public Pet copy() {
        return new Dog(super.copy());
    }
}
