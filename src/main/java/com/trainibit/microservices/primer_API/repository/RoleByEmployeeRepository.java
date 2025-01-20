package com.trainibit.microservices.primer_API.repository;

import com.trainibit.microservices.primer_API.entity.RoleByEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleByEmployeeRepository extends JpaRepository<RoleByEmployee, Long> {
}
