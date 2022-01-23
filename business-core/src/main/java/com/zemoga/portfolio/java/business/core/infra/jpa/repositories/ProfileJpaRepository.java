package com.zemoga.portfolio.java.business.core.infra.jpa.repositories;

import com.zemoga.portfolio.java.business.core.infra.jpa.entities.ProfileJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileJpaRepository extends JpaRepository<ProfileJpa, Long> {
}
