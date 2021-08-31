package com.example.woofcupid.owner;

import com.example.woofcupid.pet.Pet;
import com.example.woofcupid.pet.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    private final OwnerService ownerService;
    private final PetService petService;

    @Autowired
    public OwnerController(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @GetMapping("/owners")
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @PostMapping("/owners")
    public void newOwner(@RequestBody Owner newOwner) {
        ownerService.addNewOwner(newOwner);
    }

    @GetMapping("/owners/id/{ownerId}")
    public Owner ownerById(@PathVariable("ownerId") Long id) {
        return ownerService.findOwnerById(id);
    }

    @PutMapping("/owners/{id}")
    public void updateOwner(@RequestBody Owner newOwner,
                      @PathVariable Long id) {
        ownerService.updateOwner(newOwner, id);
    }

    @GetMapping("/owners/{lastName}")
    public List<Owner> ownerByLastName(@PathVariable("lastName")String lastName) {
        return ownerService.getOwnerByLastName(lastName);
    }

    @DeleteMapping("/owners/{ownerId}")
    public void deleteOwner(@PathVariable("ownerId")Long id) {
        ownerService.deleteOwnerById(id);
    }

    @PostMapping("/owners/{id}/newPet")
    public void newPet(@RequestBody Pet newPet,
                       @PathVariable Long id) {
        ownerService.addNewPet(newPet, id);
    }
}
