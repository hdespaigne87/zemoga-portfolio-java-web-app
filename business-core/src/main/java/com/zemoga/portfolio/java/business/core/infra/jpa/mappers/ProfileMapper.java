package com.zemoga.portfolio.java.business.core.infra.jpa.mappers;

import com.zemoga.portfolio.java.business.core.domain.entities.ProfileModel;
import com.zemoga.portfolio.java.business.core.infra.jpa.entities.ProfileJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper extends BaseJpaMapper<ProfileModel, ProfileJpa> {
}
