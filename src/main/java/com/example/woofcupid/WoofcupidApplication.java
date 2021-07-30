package com.example.woofcupid;

import com.example.woofcupid.owner.Owner;
import com.example.woofcupid.owner.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WoofcupidApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoofcupidApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(OwnerRepository repository) {
        return (args) -> {
            repository.save(new Owner(
                    "Dexter",
                    "Morgan",
                    "Miami",
                    "863-440-5710"
            ));
            repository.save(new Owner(
                    "Debra",
                    "Morgan",
                    "Miami",
                    "813-478-9646"
            ));
            repository.save(new Owner(
                    "Angel",
                    "Batista",
                    "Bartow",
                    "954-673-6553"
            ));
            repository.save(new Owner(
                    "James",
                    "Doakes",
                    "Daytona",
                    "386-691-9893"
            ));
            repository.save(new Owner(
                    "Rita",
                    "Bennett",
                    "Orlando",
                    "407-451-1448"
            ));
        };
    }
}
