package com.zemoga.portfolio.java.business.core.infra.adapters.repositories;

import com.zemoga.portfolio.java.business.core.domain.entities.ProfileModel;
import com.zemoga.portfolio.java.business.core.domain.repositories.ProfileRepositoryPort;
import com.zemoga.portfolio.java.business.core.infra.jpa.entities.ProfileJpa;
import com.zemoga.portfolio.java.business.core.infra.jpa.mappers.ProfileMapper;
import com.zemoga.portfolio.java.business.core.infra.jpa.repositories.ProfileJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProfileRepositoryAdapter implements ProfileRepositoryPort {

    private final ProfileJpaRepository profileJpaRepository;
    private final ProfileMapper profileMapper;

    @Override
    public Optional<ProfileModel> findById(Long idportfolio) {
        Optional<ProfileJpa> profileJpa = profileJpaRepository.findById(idportfolio);
        if (profileJpa.isEmpty())
            return Optional.empty();
        return Optional.of(profileMapper.toDomainModel(profileJpa.get()));
    }

    @Override
    public ProfileModel save(ProfileModel profileModel) {
        ProfileJpa profileJpa = profileMapper.toJpaModel(profileModel);
        return profileMapper.toDomainModel(profileJpaRepository.save(profileJpa));
    }
}
