package com.zemoga.portfolio.java.business.core;

import com.zemoga.portfolio.java.business.core.infra.jpa.entities.ProfileJpa;
import com.zemoga.portfolio.java.business.core.infra.jpa.repositories.ProfileJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("classpath:application-business-core.properties")
class ProfileJpaRepositoryIntegrationTest {

    @Autowired
    private ProfileJpaRepository profileJpaRepository;

    @Test
    public void whenIdExists_thenProfileShouldBeFound() {
        Optional<ProfileJpa> profileJpa = profileJpaRepository.findById(6L);
        assertTrue(profileJpa.isPresent());
    }
}
