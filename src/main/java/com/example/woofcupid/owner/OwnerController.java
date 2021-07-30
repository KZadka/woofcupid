package com.example.woofcupid.owner;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {
    private final OwnerRepository repository;

    public OwnerController(OwnerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/owners")
    List<Owner> all() {
        return (List<Owner>) repository.findAll();
    }

    @PostMapping("/owners")
    Owner newOwner(@RequestBody Owner newOwner) {
        return repository.save(newOwner);
    }

    @GetMapping("/owners/{id}")
    Owner ownerById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException(id));
    }

    @PutMapping("/owners/{id}")
    Owner updateOwner(@RequestBody Owner newOwner,
                      @PathVariable Long id) {
        return repository.findById(id)
                .map(owner -> {
                    owner.setFirstName(newOwner.getFirstName());
                    owner.setLastName(newOwner.getLastName());
                    owner.setCity(newOwner.getCity());
                    owner.setPhoneNumber(newOwner.getPhoneNumber());
                    return repository.save(owner);
                })
                .orElseGet(() -> {
                    newOwner.setId(id);
                    return repository.save(newOwner);
                });
    }

    @GetMapping("/owners/{lastName}")
    Owner ownerByLastName(@PathVariable String lastName) {
        return repository.findByLastName(lastName);
    }
}
