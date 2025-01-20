package com.trainibit.microservices.primer_API.service;

import com.trainibit.microservices.primer_API.dto.request.RoleRequest;
import com.trainibit.microservices.primer_API.dto.response.RoleResponse;
import com.trainibit.microservices.primer_API.entity.Role;
import com.trainibit.microservices.primer_API.mapper.RolMapper;
import com.trainibit.microservices.primer_API.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleResponse save(RoleRequest roleRequest) {
        //mapea para crear la entidad desde el request
        Role role = RolMapper.mapRequestToEntity(roleRequest);
        //establezca fechas
        LocalDate now = LocalDate.now();
        role.setCreatedDate(now);
        role.setUpdatedDate(now);
        //configura el estado active
        role.setActive(true);
        //guarda el rol en la base de datos
        return RolMapper.mapEntityToResponse(roleRepository.save(role));
    }
}
