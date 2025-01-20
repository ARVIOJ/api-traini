package com.trainibit.microservices.primer_API.mapper;

import com.trainibit.microservices.primer_API.dto.request.EmployeeRequest;
import com.trainibit.microservices.primer_API.dto.response.RoleByEmployeeResponse;
import com.trainibit.microservices.primer_API.entity.Employee;
import com.trainibit.microservices.primer_API.entity.Role;
import com.trainibit.microservices.primer_API.entity.RoleByEmployee;
import com.trainibit.microservices.primer_API.repository.RoleByEmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoleByEmployeeMapper {

    public static RoleByEmployee mapRequestToEntity(RoleByEmployeeRepository roleByEmployeeRepository) {
        RoleByEmployee roleByEmployee = new RoleByEmployee();
        roleByEmployee.setUuid(UUID.randomUUID());
        roleByEmployee.setCreatedDate(LocalDate.now());
        roleByEmployee.setUpdatedDate(LocalDate.now());
        roleByEmployee.setActive(true);

        return roleByEmployee;
    }

    public static RoleByEmployeeResponse mapEntityToResponse(RoleByEmployee roleByEmployee) {
        RoleByEmployeeResponse roleByEmployeeResponse = new RoleByEmployeeResponse();
        roleByEmployeeResponse.setUuid(roleByEmployee.getUuid());
        roleByEmployeeResponse.setCreatedDate(roleByEmployee.getCreatedDate());
        roleByEmployeeResponse.setUpdatedDate(roleByEmployee.getUpdatedDate());
        roleByEmployeeResponse.setActive(roleByEmployee.getActive());
        return roleByEmployeeResponse;
    }


}
