package org.medellinjug.mastering.returning;


import java.util.*;

public class DogService {

    private PetsRepo petsRepo;

    public DogService(PetsRepo petsRepo) {
        this.petsRepo = petsRepo;
    }

    public List<Dog> getAllDogsAsDogList() {
        List<Pet> pets = petsRepo.filter(PetType.DOG);
        if (pets.isEmpty()) {
            return Collections.emptyList(); // what if we return null???
        }
        List<Dog> dogs = new ArrayList<>();
        for (Pet pet : pets) {
            dogs.add((Dog)pet);
        }
        return dogs;
    }

    public List<Dog> getAllDogsADogCopyList() {
        List<Pet> pets = petsRepo.filter(PetType.DOG);
        List<Dog> dogs = new ArrayList<>();
        for (Pet pet : pets) {
            Dog dog = (Dog)pet.copy();
            dogs.add(dog);
        }
        return dogs;
    }

    public Dog[] getAllPoodleDogsAsArray() {
        List<Dog> dogs = getAllDogsADogCopyList();
        dogs.removeIf(pet -> !pet.getBreed().equals("poodle"));
        Dog[] result = new Dog[dogs.size()];
        dogs.toArray(result);
        return result;
    }


    public Dog getDogByCode(Integer code) {
        Dog dog = (Dog) petsRepo.readPet(code);
        return dog;
    }

    public Dog getCopyOfDog(Integer code) {
        Dog dog = (Dog) petsRepo.readPet(code).copy();
        return dog;
    }

    public Optional<Dog> getOptionalDog(Integer code) {
        Dog dog = (Dog) petsRepo.readPet(code);
        return Optional.of(dog);
    }

    public Void deleteAllDogs() {
        petsRepo.deleteAll();
        return null;
    }

    public double totalCostOfAllDogs(Double totalCost) { // Pass output parameter as reference
        List<Dog> dogs = getAllDogsAsDogList();
        for (Dog dog : dogs) {
            totalCost += dog.getCost();
        }
        return totalCost;
    }

    public String getDogBreed(Dog dog) {
        if (getAllDogsAsDogList().contains(dog)) {
            return dog.getBreed();
        }
        return "dog not found"; // throw new IllegalArgumentException("Breed name couldn't be obtained: Input dog is not found");
    }

    public boolean removeAllDogsThatAreCats() { // returning a boolean value to determine if any cats are removed
        List<Pet> dogs = petsRepo.getAll();
        return dogs.removeIf(dog -> dog.getType().equals(PetType.CAT));
    }

}
