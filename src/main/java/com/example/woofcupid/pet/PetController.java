package com.example.woofcupid.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/pets/{ownerId}")
    public Optional<Pet> getPetByNameAndOwnerId(@PathVariable Long ownerId,
                                                @RequestParam String petName) {
        return petService.getPetByNameAndOwnerId(petName, ownerId);
    }
}
