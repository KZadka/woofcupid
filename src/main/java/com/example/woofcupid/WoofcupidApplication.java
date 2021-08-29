package com.example.woofcupid;

import com.example.woofcupid.owner.Owner;
import com.example.woofcupid.owner.OwnerRepository;
import com.example.woofcupid.pet.Pet;
import com.example.woofcupid.pet.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@SpringBootApplication
public class WoofcupidApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoofcupidApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(OwnerRepository ownerRepository, PetRepository petRepository) {
        return (args) -> {
            ownerRepository.save(new Owner(
                    "Dexter",
                    "Morgan",
                    "Miami",
                    "863-440-5710",
                    "dexter.morgan@gmail.com"
            ));
            ownerRepository.save(new Owner(
                    "Debra",
                    "Morgan",
                    "Miami",
                    "813-478-9646",
                    "debra.morgan@gmail.com"
            ));
            ownerRepository.save(new Owner(
                    "Angel",
                    "Batista",
                    "Bartow",
                    "954-673-6553",
                    "angel.batista@gmail.com"
            ));
            ownerRepository.save(new Owner(
                    "James",
                    "Doakes",
                    "Daytona",
                    "386-691-9893",
                    "james.doakes@gmail.com"
            ));
            ownerRepository.save(new Owner(
                    "Rita",
                    "Bennett",
                    "Orlando",
                    "407-451-1448",
                    "rita.bennett@gmail.com"
            ));
            petRepository.save(new Pet(
                    "Wolfy",
                    "2015-08-15",
                    "Male",
                    "Dog",
                    "Calm",
                    1L
            ));
        };
    }
}
