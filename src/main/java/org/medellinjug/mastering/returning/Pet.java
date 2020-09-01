package org.medellinjug.mastering.returning;

import java.util.List;

public class Pet {

    protected Integer code;
    protected PetType type;
    protected Double cost;
    protected List<String> attributes;
    protected String breed;

    public Pet() {
    }

    public Pet(PetType type, Double cost, List<String> attributes, String breed) {
        this.type = type;
        this.cost = cost;
        this.attributes = attributes;
        this.breed = breed;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Pet copy() {
        return new Pet(type, cost, attributes, breed);
    }

}
