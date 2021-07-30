package com.example.woofcupid.owner;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
    Owner findById(long id);
    Owner findByCity(String city);

}
