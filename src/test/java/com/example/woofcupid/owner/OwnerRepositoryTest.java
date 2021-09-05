package com.example.woofcupid.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindOwnerByEmail() {
        //given
        String email = "tester.morgan@gmail.com";
        Owner owner = new Owner(
                "Tester",
                "Morgan",
                "Testercity",
                "000-111-2222",
                email
        );
        underTest.save(owner);

        //when
        Optional<Owner> expected = underTest.findByEmail(email);

        //then
        assertThat(expected.isPresent()).isTrue();
    }

    @Test
    void itShouldFindOwnerByLastName() {
        //given
        String lastName = "Morgan";
        Owner owner = new Owner(
                "Tester",
                lastName,
                "Testercity",
                "000-111-2222",
                "tester.morgan@gmail.com"
        );
        underTest.save(owner);

        //when
        List<Owner> expected = underTest.findAllByLastName(lastName);

        //then
        assertThat(expected).isNotNull();
    }
}