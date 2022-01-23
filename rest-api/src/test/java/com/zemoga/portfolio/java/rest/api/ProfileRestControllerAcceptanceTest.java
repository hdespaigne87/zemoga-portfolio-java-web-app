package com.zemoga.portfolio.java.rest.api;

import com.zemoga.portfolio.java.business.core.infra.jpa.entities.ProfileJpa;
import com.zemoga.portfolio.java.business.core.infra.jpa.repositories.ProfileJpaRepository;
import com.zemoga.portfolio.java.rest.api.controllers.ProfileRestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProfileRestController.class)
class ProfileRestControllerAcceptanceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProfileJpaRepository profileJpaRepository;

    @BeforeEach
    public void setUp() {
        Mockito.when(profileJpaRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(buildProfile()));
    }

    private ProfileJpa buildProfile() {
        return ProfileJpa.builder()
                .idportfolio(1L)
                .names("Husseyn")
                .lastNames("Despaigne")
                .build();
    }

    @Test
    void whenIdExists_thenProfileShouldBeFound() throws Exception {
        mvc.perform(get("/profile/6").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idportfolio").value(1L))
                .andExpect(jsonPath("$.names").value("Husseyn"))
                .andExpect(jsonPath("$.lastNames").value("Despaigne"));
    }
}
