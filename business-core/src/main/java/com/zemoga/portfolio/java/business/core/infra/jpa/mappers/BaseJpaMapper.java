package com.zemoga.portfolio.java.business.core.infra.jpa.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseJpaMapper<D, JPA> {

    D toDomainModel(JPA jpaModel);

    @InheritInverseConfiguration
    JPA toJpaModel(D domainModel);

    List<D> toDomainModel(List<JPA> list);

    @InheritInverseConfiguration
    List<JPA> toJpaModel(List<D> list);

    default Page<D> toDomainModel(Page<JPA> page) {
        return page.map(entity -> toDomainModel(entity));
    }
}
