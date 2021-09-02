package com.example.woofcupid.pet;

import com.example.woofcupid.owner.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public PetService(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getOwnerAllPets(Long ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }

    public void addNewPet(Pet newPet, Long ownerId) {
        Optional<Pet> petOptional = petRepository
                .findByName(newPet.getName());
        if (petOptional.isPresent()) {
            throw new IllegalStateException("Name taken");
        }
        newPet.setOwner(ownerRepository.getById(ownerId));
        petRepository.save(newPet);
    }

    public void updatePet(Pet newPet, Long ownerId, String petName) {
        petRepository.findPetByNameAndOwnerId(petName, ownerId)
                .map(pet -> {
                    pet.setName(newPet.getName());
                    pet.setBirthDate(newPet.getBirthDate());
                    pet.setGender(newPet.getGender());
                    pet.setType(newPet.getType());
                    pet.setCharacter(newPet.getCharacter());
                    return petRepository.save(pet);
                })
                .orElseGet(() -> {
                    newPet.setName(petName);
                    return petRepository.save(newPet);
                });
    }

    public Optional<Pet> getPetByNameAndOwnerId(String name, Long ownerId) {
        return petRepository.findPetByNameAndOwnerId(name, ownerId);
    }
}
