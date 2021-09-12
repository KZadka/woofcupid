package com.example.woofcupid.owner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
class OwnerControllerMockMvcStandaloneTest {

    private MockMvc mvc;

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    private JacksonTester<Owner> jsonOwner;
    private JacksonTester<List<Owner>> jsonOwnerList;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(ownerController)
                .build();
    }

    private final List<Owner> owners = new ArrayList<>() {{
        add(new Owner("Dexter",
                "Morgan",
                "Testercity",
                "000-111-2222",
                "dexter.morgan@gmail.com"));
        add(new Owner("Debra",
                "Morgan",
                "Testercity",
                "333-444-22222",
                "debra.morgan@gmail.com"));
    }};
    @Test
    void canRetrieveAllWhenExists() throws Exception {
        //given
        given(ownerService.getAllOwners())
                .willReturn(owners);

        //when
        MockHttpServletResponse response = mvc.perform(
                get("/owners")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonOwnerList.write(owners).getJson()
        );
    }

    @Test
    void canRetrieveAllWhenDoesNotExists() throws Exception {
        //given
        given(ownerService.getAllOwners())
                .willThrow(new IllegalStateException());

        //when
        MockHttpServletResponse response = mvc.perform(
                        get("/owners")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getContentAsString()).isEmpty();
    }

    @Test
    void newOwner() {
    }

    @Test
    void ownerById() {
    }

    @Test
    void updateOwner() {
    }

    @Test
    void ownerByLastName() {
    }

    @Test
    void deleteOwner() {
    }

    @Test
    void newPet() {
    }

    @Test
    void ownerAllPets() {
    }

    @Test
    void updateOwnersPet() {
    }
}