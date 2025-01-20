package com.trainibit.microservices.primer_API.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public class DepartamentoResponse {
    private String description;
    private UUID uuid;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


}
