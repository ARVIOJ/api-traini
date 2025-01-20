package com.trainibit.microservices.primer_API.dto.request;

import com.trainibit.microservices.primer_API.entity.Employee;
import com.trainibit.microservices.primer_API.entity.Role;

import java.time.LocalDate;
import java.util.UUID;

public class RoleByEmployeeRequest {

    private Employee employee;
    private Role role;
    private Boolean active = false;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
