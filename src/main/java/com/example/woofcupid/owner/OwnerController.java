package com.example.woofcupid.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
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
}
