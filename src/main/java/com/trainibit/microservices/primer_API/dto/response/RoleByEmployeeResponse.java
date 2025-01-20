package com.trainibit.microservices.primer_API.dto.response;

import com.trainibit.microservices.primer_API.entity.Employee;
import com.trainibit.microservices.primer_API.entity.Role;

import java.time.LocalDate;
import java.util.UUID;

public class RoleByEmployeeResponse {

    private UUID uuid;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private Boolean active = false;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
