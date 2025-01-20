package com.trainibit.microservices.primer_API.repository;

import com.trainibit.microservices.primer_API.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByUuid(UUID uuid);
}
