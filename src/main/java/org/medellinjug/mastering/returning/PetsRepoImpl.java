package org.medellinjug.mastering.returning;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PetsRepoImpl implements PetsRepo {

    List<Pet> petsDB = new ArrayList<>();

    @Override
    public Pet addPet(Pet pet) {
        if (petsDB.add(pet) == true ) {
            Integer code = petsDB.indexOf(pet);
            pet.setCode(code);
        }
        return pet.getCode() != null ? pet : null;
    }

    @Override
    public Pet readPet(Pet pet) {
        return readPet(pet.getCode());
    }

    @Override
    public Pet readPet(Integer code) {
        return internalFindByCode(code).orElse(null);
    }

    private Optional<Pet> internalFindByCode(Integer code) {
        if (code == null) {
            return Optional.empty();
        }
        if (code >=0 && code < petsDB.size()) {
            Pet found = petsDB.get(code);
            return Optional.of(found);
        }
        return petsDB.stream()
                .filter( m -> m.getCode().intValue() == code.intValue())
                .findFirst();
    }

    @Override
    public Pet updatePet(Pet pet) {
        Optional<Pet> toUpdate = internalFindByCode(pet.getCode());
        if (toUpdate.isPresent()) {
            Pet updated = toUpdate.get();
            updated.setType(pet.getType());
            updated.setAttributes(pet.getAttributes());
            updated.setCost(pet.getCost());
        }
        return toUpdate.orElse(null);
    }

    @Override
    public Pet deletePet(Pet pet) {
        Optional<Pet> toDelete = internalFindByCode(pet.getCode());
        if (toDelete.isPresent()) {
            int deleteIndex = petsDB.indexOf(toDelete.get());
            petsDB.set(deleteIndex, null);
        }
        return toDelete.orElse(null);
    }

    @Override
    public List<Pet> getAll() {
        return petsDB;
    }

    @Override
    public void deleteAll() {
        petsDB.clear();
    }

    @Override
    public List<Pet> filter(PetType type) {
        return petsDB.stream()
                .filter(p -> p != null && p.getType() == type)
                .collect(Collectors.toList());
    }

    @Override
    public List<Pet> filter(String breed) {
        return petsDB.stream()
                .filter(p -> p != null && p.getBreed().equals(breed))
                .collect(Collectors.toList());
    }
}
