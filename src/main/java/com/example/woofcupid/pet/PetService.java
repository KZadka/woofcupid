package com.example.woofcupid.pet;

import com.example.woofcupid.owner.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public void addNewPet(Pet newPet, Long ownerId) {
//        petRepository.save(newPet);
//        newPet.setOwner(this.ownerRepository.findById(ownerId));
//    }
}
