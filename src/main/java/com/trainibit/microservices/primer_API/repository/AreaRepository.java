package com.trainibit.microservices.primer_API.repository;

import com.trainibit.microservices.primer_API.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AreaRepository extends JpaRepository<Departamento, Integer> {
    Optional<Departamento> findByUuid(UUID uuid);
}
