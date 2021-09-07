package com.example.woofcupid.owner;

import com.example.woofcupid.pet.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    private OwnerService serviceUnderTest;

    @BeforeEach
    void setUp() {
        serviceUnderTest = new OwnerService(ownerRepository, petRepository);
    }

    @Test
    void canGetAllOwners() {
        //when
        serviceUnderTest.getAllOwners();
        //then
        verify(ownerRepository).findAll();
    }

    @Test
    void canAddNewOwner() {
        //given
        Owner owner = new Owner(
                "Tester",
                "Morgan",
                "Testercity",
                "000-111-2222",
                "tester.morgan@gmail.com"
        );
        //when
        serviceUnderTest.addNewOwner(owner);
        //then
        ArgumentCaptor<Owner> ownerArgumentCaptor = ArgumentCaptor.forClass(Owner.class);
        verify(ownerRepository).save(ownerArgumentCaptor.capture());
        Owner capturedOwner = ownerArgumentCaptor.getValue();
        assertThat(capturedOwner).isEqualTo(owner);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        //given
        Owner owner = new Owner(
                "Tester",
                "Morgan",
                "Testercity",
                "000-111-2222",
                "tester.morgan@gmail.com"
        );
        given(ownerRepository.findByEmail(anyString()))
                .willReturn(Optional.of(owner));
        //when
        //then
        assertThatThrownBy(() -> serviceUnderTest.addNewOwner(owner))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Email taken");
    }

    @Test
    void canFindOwnerById() {
        //given
        Long ownerId = 1L;
        Owner owner = new Owner(
                "Tester",
                "Morgan",
                "Testercity",
                "000-111-2222",
                "tester.morgan@gmail.com"
        );
        owner.setId(ownerId);

        //when
        doReturn(Optional.of(owner)).when(ownerRepository).findById(ownerId);
        Owner expected = serviceUnderTest.findOwnerById(ownerId);

        //then
        assertThat(expected).isEqualTo(owner);

    }

    @Test
    void canUpdateOwner() {
        //given
        OwnerService ownerService = mock(OwnerService.class);
        Long ownerId = 1L;
        Owner updatedOwner = new Owner(
                "1",
                "2",
                "3",
                "4",
                "5"
        );

        //when
        ownerService.updateOwner(updatedOwner, ownerId);

        //then
        verify(ownerService, times(1)).updateOwner(updatedOwner, ownerId);
    }

    @Test
    void getOwnerByLastName() {
    }

    @Test
    void deleteOwnerById() {
    }
}