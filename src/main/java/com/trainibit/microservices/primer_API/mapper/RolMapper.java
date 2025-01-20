package com.trainibit.microservices.primer_API.mapper;

import com.trainibit.microservices.primer_API.dto.request.RoleRequest;
import com.trainibit.microservices.primer_API.dto.response.RoleResponse;
import com.trainibit.microservices.primer_API.entity.Role;

import java.time.LocalDate;
import java.util.UUID;

public class RolMapper {

    public static Role mapRequestToEntity(RoleRequest roleRequest) {
        Role role = new Role();
        role.setUuid(UUID.randomUUID());
        role.setDescription(roleRequest.getDescription());
        role.setCreatedDate(LocalDate.now());
        role.setUpdatedDate(LocalDate.now());
        role.setActive(true);
        return role;
    }

    public static RoleResponse mapEntityToResponse(Role role) {
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setUuid(role.getUuid());
        roleResponse.setDescription(role.getDescription());
        role.setActive(true);

        return roleResponse;
    }
}
