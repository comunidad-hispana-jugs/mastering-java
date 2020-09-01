package org.medellinjug.mastering.returning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class DogServiceTest {


    private DogService service;

    private PetsRepo repository;

    private Dog uniqueDog = new Dog("unique");

    private Cat notADog = new Cat();

    @BeforeEach
    void setUp() {
        repository = new PetsRepoImpl();
        repository.addPet(uniqueDog);
        repository.addPet(notADog);
        service = new DogService(repository);
    }

    @Test
    void testDogsListIsEmptyIfNoDogsAreFound() {
        // Given
        repository.getAll().clear();
        // When
        List<Dog> allDogs = service.getAllDogsAsDogList();
        // Then
        Assertions.assertNotNull(allDogs, "Returned list must be empty rather than null");
        Assertions.assertTrue(allDogs.isEmpty(), "Dogs list must be empty");
    }

    @Test
    void testGetAllDogsGetsOriginalObjects() {
        // Given
        Dog labrador = new Dog("labrador");
        repository.addPet(labrador);
        List<Pet> allPets = repository.getAll();
        List<Pet> dogPets = allPets.stream().filter(pet -> pet.type == PetType.DOG).collect(Collectors.toList());
        // When
        List<Dog> allDogs = service.getAllDogsAsDogList();
        // Then
        Assertions.assertNotNull(allDogs, "Returned list contains dogs");
        Assertions.assertTrue(allDogs.size() == 2, "Incorrect count of dogs");
        Assertions.assertTrue(allDogs.equals(dogPets), "List of dogs and pets who are dogs is equal");
    }

    @Test
    void testGetAllDogsGetsACopyOfExistingDogs() {
        // Given
        Dog labrador = new Dog("labrador");
        repository.addPet(labrador);
        List<Pet> allPets = repository.getAll();
        List<Pet> dogPets = allPets.stream().filter(pet -> pet.type == PetType.DOG).collect(Collectors.toList());
        // When
        List<Dog> allDogs = service.getAllDogsADogCopyList();
        // Then
        Assertions.assertNotNull(allDogs, "Returned list contains dogs");
        Assertions.assertTrue(allDogs.size() == 2, "Incorrect count of dogs");
        Assertions.assertFalse(allDogs.equals(dogPets), "List of dogs and pets who are dogs is not equal");
        allDogs.forEach( dog -> dogPets.forEach(pet -> {
            if (pet.code == dog.code) {
                Assertions.assertFalse(pet == dog);
                Assertions.assertTrue(pet.type == dog.type);
                Assertions.assertTrue(pet.attributes == dog.attributes);
                Assertions.assertTrue(pet.breed == dog.breed);
                Assertions.assertTrue(pet.cost == dog.cost);
            }
        }));
    }

    @Test
    public void testGetAllDogsGetsAsCopyReturnsEmpty() {
        // given
        repository.deleteAll();
        // when
        List<Dog> emptyDogs = service.getAllDogsADogCopyList();
        // then
        Assertions.assertTrue(emptyDogs.isEmpty(), "Dogs must be empty");
    }

    @Test
    void testGetArrayOfPoodlesEmptyOrNot() {
        // given
        Dog poodle1 = new Dog("poodle");
        Dog poodle2 = new Dog("poodle");
        repository.addPet(poodle1);
        repository.addPet(poodle2);
        // when
        Dog[] poodles = service.getAllPoodleDogsAsArray();
        // then
        Assertions.assertNotNull(poodles, "Poodles array is not null");
        Assertions.assertTrue(poodles.length == 2, "Poodles array length is incorrect");
        // given
        repository.deletePet(poodle1);
        repository.deletePet(poodle2);
        // when
        Dog[] noPoodles = service.getAllPoodleDogsAsArray();
        // then
        Assertions.assertNotNull(noPoodles, "Poodles array is not null");
        Assertions.assertTrue(noPoodles.length == 0, "Poodles array length is incorrect");
    }

    @Test
    void testGetDifferentWaysToRetrieveASingleDog() {
        // given
        Dog terrier = (Dog)repository.addPet(new Dog("terrier"));
        int dogCode = terrier.getCode();
        // when
        Dog originalObject = service.getDogByCode(dogCode);
        // then
        Assertions.assertEquals(terrier, originalObject, "Dog object is not the same");
        Assertions.assertTrue(terrier.equals(originalObject), "Dog objects are not equal");
        // when
        Dog copyOfObject = service.getCopyOfDog(dogCode);
        // then
        Assertions.assertNotEquals(terrier, copyOfObject, "Dog obtained is not the same");
        Assertions.assertTrue(terrier.getAttributes().equals((copyOfObject.getAttributes())) &&
                terrier.getType().equals(copyOfObject.getType()) &&
                terrier.getBreed() == copyOfObject.getBreed() &&
                terrier.getCost() == copyOfObject.getCost(), "Dog objects are not equal");
        // when
        Optional<Dog> optionalOfDog = service.getOptionalDog(dogCode);
        // then
        Assertions.assertTrue(optionalOfDog.isPresent(), "Optional contains an object");
        Assertions.assertTrue(optionalOfDog.get() instanceof Dog, "Optional contains a Dog");
        Assertions.assertEquals(terrier, optionalOfDog.get(), "Dog obtained is not the same");
        Assertions.assertTrue(terrier.equals(optionalOfDog.get()), "Dog objects are not equal");

        optionalOfDog.ifPresent( //Checks: optional is present and contains a dog or else fails the test
                found -> Assertions.assertEquals(terrier, found, "Dog objects are not equal")
        );
    }

    @Test
    void testHowToDeleteAllDogs() {
        // given
        Dog dog1 = (Dog)repository.addPet(new Dog("adopted"));
        Dog dog2 = (Dog)repository.addPet(new Dog("adopted"));
        Dog dog3 = (Dog)repository.addPet(new Dog("adopted"));
        // when
        Void uselessVoid = service.deleteAllDogs();
        // then
        Assertions.assertFalse(repository.getAll().contains(dog1), "Instance dog1 was not deleted");
        Assertions.assertFalse(repository.getAll().contains(dog2), "Instance dog2 was not deleted");
        Assertions.assertFalse(repository.getAll().contains(dog3), "Instance dog3 was not deleted");
        Assertions.assertTrue(repository.getAll().isEmpty(),
                                "Pets repository should contain only nulls but is empty");
        Assertions.assertTrue(repository.getAll().stream().allMatch(o -> o == null), "All objects on pet repository are null");
        Assertions.assertNull(uselessVoid, "Returned object from deletion is null");
    }

    @Test
    void testHowToRemoveCatsFromDogs() {
        // given
        boolean aCatPetExists = repository.readPet(notADog).getType().equals(PetType.CAT);
        // when
        boolean catsRemoved = service.removeAllDogsThatAreCats();
        // then
        Assertions.assertTrue(aCatPetExists, "There was no cat on the initial pets repository");
        Assertions.assertTrue(catsRemoved, "Removing cats shall have returned true");
        // when
        boolean removedCatsTwice = service.removeAllDogsThatAreCats();
        // then
        Assertions.assertFalse(removedCatsTwice, "Removing cats for a second time shall have returned false");
    }

    @Test
    void testHowToCalculateAllDogsCost() {
        // given
        Dog cheapDog = new Dog("free");
        cheapDog.setCost(1.0);
        Dog expensiveDog = new Dog("corgi");
        expensiveDog.setCost(1000000.0);
        repository.addPet(cheapDog);
        repository.addPet(expensiveDog);
        // when
        Double initialCost = 0.0;
        double totalCost = service.totalCostOfAllDogs(initialCost);
        // then
        Assertions.assertEquals(0.0, initialCost, "Initial cost object shall keep the same value");
        Assertions.assertEquals(1001001.0, totalCost,
                "Total cost calculated is not the expected value 1001001.0");
    }

    @Test
    void testGetDogsBreedAndBreedError() {
        // given
        Dog frenchPoodle = new Dog("poodle frances");
        repository.addPet(frenchPoodle);
        String dogBreedErrorMessage = "dog not found";
        // when
        String breedResponse = service.getDogBreed(frenchPoodle);
        // then
        Assertions.assertNotNull(breedResponse, "Breed response cannot be null");
        Assertions.assertEquals("poodle frances", breedResponse, "Breed response string is not \"poodle frances\"");
        // given
        repository.deletePet(frenchPoodle);
        // when
        String errorResponse = service.getDogBreed(frenchPoodle);
        // then
        Assertions.assertNotNull(errorResponse, "Breed response cannot be null");
        Assertions.assertEquals("dog not found", errorResponse, "Breed response string is not \"dog not found\"");
    }

}
