package com.zemoga.portfolio.java.business.core.domain.repositories;

import com.zemoga.portfolio.java.business.core.domain.entities.ProfileModel;

import java.util.Optional;

public interface ProfileRepositoryPort {

    Optional<ProfileModel> findById(Long idportfolio);

    ProfileModel save(ProfileModel profileModel);
}
