package com.example.woofcupid.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepository repository;

    @Autowired
    public OwnerService(OwnerRepository repository) {
        this.repository = repository;
    }


}
