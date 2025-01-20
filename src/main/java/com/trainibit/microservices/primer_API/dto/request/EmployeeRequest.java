package com.trainibit.microservices.primer_API.dto.request;

import com.trainibit.microservices.primer_API.entity.Departamento;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class EmployeeRequest {

    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private LocalDate lastAccess;
    private UUID uuid;
    private Departamento area;
    private List<UUID> roleUuids;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDate lastAccess) {
        this.lastAccess = lastAccess;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Departamento getArea() {
        return area;
    }

    public void setArea(Departamento area) {
        this.area = area;
    }

    public List<UUID> getRoleUuids() {
        return roleUuids;
    }

    public void setRoleUuids(List<UUID> roleUuids) {
        this.roleUuids = roleUuids;
    }
}
