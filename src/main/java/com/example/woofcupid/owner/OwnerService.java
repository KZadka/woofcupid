package com.example.woofcupid.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public  List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    public void addNewOwner(Owner owner) {
        Optional<Owner> ownerOptional = ownerRepository
                .findByEmail(owner.getEmail());
        if (ownerOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        ownerRepository.save(owner);
    }

    public Owner findOwnerById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException(id));
    }

    public void updateOwner(Owner newOwner, Long id) {
         ownerRepository.findById(id)
                .map(owner -> {
                    owner.setFirstName(newOwner.getFirstName());
                    owner.setLastName(newOwner.getLastName());
                    owner.setCity(newOwner.getCity());
                    owner.setPhoneNumber(newOwner.getPhoneNumber());
                    owner.setEmail(newOwner.getEmail());
                    return ownerRepository.save(owner);
                })
                .orElseGet(() -> {
                    newOwner.setId(id);
                    return ownerRepository.save(newOwner);
                });
    }

    public List<Owner> getOwnerByLastName(String lastName) {
        return ownerRepository.findAllByLastName(lastName);
    }

    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }
}
