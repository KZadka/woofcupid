package com.example.woofcupid.owner;

public class OwnerNotFoundException extends RuntimeException {

    OwnerNotFoundException(Long id) {
        super("Could not find owner " + id);
    }

    OwnerNotFoundException(String lastName) {
        super("Could not find owner " + lastName);
    }
}
