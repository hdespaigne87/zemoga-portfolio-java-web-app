package com.zemoga.portfolio.java.business.core;

import com.zemoga.portfolio.java.business.core.domain.repositories.ProfileRepositoryPort;
import com.zemoga.portfolio.java.business.core.domain.services.ProfileService;
import com.zemoga.portfolio.java.business.core.exceptions.EntityNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class ProfileServiceUnitTest {

    @MockBean
    private ProfileRepositoryPort profileRepositoryPort;

    private ProfileService profileService;

    @BeforeEach
    public void setUp() {
        Mockito.when(profileRepositoryPort.findById(Mockito.anyLong()))
                .thenReturn(Optional.empty());
        profileService = new ProfileService(profileRepositoryPort, null);
    }

    @Test
    public void whenIdDoesNotExists_thenEntityNotFoundExceptionShouldBeThrown() {
        assertThrows(EntityNotFound.class, () -> {
            profileService.getProfileInfoById(1L, null);
        });
    }
}
