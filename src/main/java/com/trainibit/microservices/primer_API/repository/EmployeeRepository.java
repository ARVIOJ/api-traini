package com.trainibit.microservices.primer_API.repository;

import com.trainibit.microservices.primer_API.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmailAddressAndPassword(String emailId, String password);
    Optional<Employee> findByUuid(UUID uuid);
}
