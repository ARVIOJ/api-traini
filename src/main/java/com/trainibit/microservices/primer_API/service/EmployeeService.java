package com.trainibit.microservices.primer_API.service;

import com.trainibit.microservices.primer_API.dto.request.EmployeeRequest;
import com.trainibit.microservices.primer_API.dto.response.EmployeeResponse;
import com.trainibit.microservices.primer_API.entity.Departamento;
import com.trainibit.microservices.primer_API.entity.Employee;
import com.trainibit.microservices.primer_API.entity.Role;
import com.trainibit.microservices.primer_API.entity.RoleByEmployee;
import com.trainibit.microservices.primer_API.exceptions.ResourceNotException;
import com.trainibit.microservices.primer_API.mapper.EmployeeMapper;
import com.trainibit.microservices.primer_API.repository.AreaRepository;
import com.trainibit.microservices.primer_API.repository.EmployeeRepository;
import com.trainibit.microservices.primer_API.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AreaRepository areaRepository;


    /*muestra_todo de la DB*/
    public List<EmployeeResponse> buscarTodos() {
        //Logica de negocio
        return EmployeeMapper.mapEntityListToResponseList(employeeRepository.findAll());
    }

    @Transactional
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        //traemos el area por uuid
        Departamento area = areaRepository.findByUuid(employeeRequest.getArea().getUuid())
                .orElseThrow(() -> new ResourceNotException("Area no existe"));

        Employee employee = EmployeeMapper.mapRequestToEntity(employeeRequest, area);

        List<RoleByEmployee> roles = new ArrayList<>();
        if (employeeRequest.getRoleUuids() != null) {
            for (UUID uuid : employeeRequest.getRoleUuids()) {
                Role role = roleRepository.findByUuid(uuid)
                        .orElseThrow(() -> new ResourceNotException("Role no existe"));
                RoleByEmployee roleByEmployee = new RoleByEmployee();
                roleByEmployee.setRole(role);
                roleByEmployee.setEmployee(employee);
                roleByEmployee.setUuid(UUID.randomUUID());
                roleByEmployee.setCreatedDate(LocalDate.now());
                roleByEmployee.setUpdatedDate(LocalDate.now());
                roleByEmployee.setActive(true);
                roles.add(roleByEmployee);
            }
            employee.setRoles(roles);
        }
        //mapea y guarda en la base de datos
        return EmployeeMapper.mapEntityToResponse(employeeRepository.save(employee));
    }

    //buscar por id
    public EmployeeResponse getById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotException("Employee not exist with UUID :" + id));
        return EmployeeMapper.mapEntityToResponse(employee);
    }

    //busca por uuid
    public EmployeeResponse getByUuid(UUID uuid) {
        Employee employee = employeeRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotException("Employee not exist with UUID: " + uuid));
        return EmployeeMapper.mapEntityToResponse(employee);
    }

    //update employees
    public EmployeeResponse update(UUID uuid, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotException("Employee not exist with uuid: " + uuid));
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmailAddress(employeeRequest.getEmailId());
        return EmployeeMapper.mapEntityToResponse(employeeRepository.save(employee));
    }

    public void delete(UUID uuid) {
        Employee employee = employeeRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotException("Employee not exist with uuid :" + uuid));
        employeeRepository.delete(employee);
    }

}
