package org.medellinjug.mastering.returning;


import java.util.List;

public interface PetsRepo {

    Pet addPet(Pet pet);

    Pet readPet(Pet pet);

    Pet readPet(Integer code);

    Pet updatePet(Pet pet);

    Pet deletePet(Pet pet);

    List<Pet> getAll();

    void deleteAll();

    List<Pet> filter(PetType type);

    List<Pet> filter(String breed);

}
