package com.trainibit.microservices.primer_API.mapper;

import com.trainibit.microservices.primer_API.dto.request.EmployeeRequest;
import com.trainibit.microservices.primer_API.dto.response.DepartamentoResponse;
import com.trainibit.microservices.primer_API.dto.response.EmployeeResponse;
import com.trainibit.microservices.primer_API.dto.response.RoleResponse;
import com.trainibit.microservices.primer_API.entity.Departamento;
import com.trainibit.microservices.primer_API.entity.Employee;
import com.trainibit.microservices.primer_API.entity.Role;
import com.trainibit.microservices.primer_API.entity.RoleByEmployee;
import com.trainibit.microservices.primer_API.exceptions.ResourceNotException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeMapper {

    public static Employee mapRequestToEntity(EmployeeRequest employeeRequest, Departamento area) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmailAddress(employeeRequest.getEmailId());
        employee.setPassword(employeeRequest.getPassword());
        employee.setLastAccess(employeeRequest.getLastAccess());
        //employee.setUuid(employeeRequest.getUuid());
        employee.setUuid(UUID.randomUUID());

        //Asignacion de avance
        employee.setCreatedDate(LocalDate.now());
        employee.setUpdatedDate(LocalDate.now());
        employee.setActive(true);//esta activo por defecto
        employee.setDepartamento(area); //asignamos una area

        return employee;
    }

    public static EmployeeResponse mapEntityToResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setEmailId(employee.getEmailAddress());
        employeeResponse.setLastAccess(employee.getLastAccess());
        employeeResponse.setUuid(employee.getUuid());

        //Mapear el Departamento(Area)
        Departamento area = employee.getDepartamento();//obtenemos el uuid
        if (area != null) { //Si lo encuentra
            DepartamentoResponse areaResponse = new DepartamentoResponse();
            //Manda a traer los datos de Area
            areaResponse.setUuid(area.getUuid());
            areaResponse.setDescription(area.getDescription());
            //Alamacena en DB
            employeeResponse.setArea(areaResponse);
        } else {
            employeeResponse.setArea(null);
            throw new ResourceNotException("El area no existe");
        }

        //Mapear el Role
        List<RoleResponse> roleResponse = new ArrayList<>();//Lista
        for (RoleByEmployee roleByEmployee : employee.getRoles()) { //recorremos los roles del empleado
            Role role = roleByEmployee.getRole();//Obtenemos uuid
            RoleResponse response = new RoleResponse();
            //Traemos los datos
            response.setUuid(role.getUuid());
            response.setDescription(role.getDescription());
            //almacenamos en DB
            roleResponse.add(response);
        }
        employeeResponse.setRole(roleResponse);

        return employeeResponse;
    }

    public static List<EmployeeResponse> mapEntityListToResponseList(List<Employee> employees) {
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        for (Employee employee : employees) {
            employeeResponseList.add(mapEntityToResponse(employee));
        }
        return employeeResponseList;
    }
}
