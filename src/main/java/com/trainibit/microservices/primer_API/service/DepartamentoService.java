package com.trainibit.microservices.primer_API.service;

import com.trainibit.microservices.primer_API.dto.request.DepartamentoRequest;
import com.trainibit.microservices.primer_API.dto.response.DepartamentoResponse;
import com.trainibit.microservices.primer_API.entity.Departamento;
import com.trainibit.microservices.primer_API.mapper.DepartamentoMapper;
import com.trainibit.microservices.primer_API.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class DepartamentoService {

    @Autowired
    private AreaRepository areaRepository;

    public DepartamentoResponse save(DepartamentoRequest departamentoRequest) {
        Departamento departamento = DepartamentoMapper.mapRequesstToEntity(departamentoRequest);
        LocalDate now = LocalDate.now();
        departamento.setCreatedDate(now);
        departamento.setUpdatedDate(now);
        departamento.setActive(true);
        return DepartamentoMapper.mapEntityToResponse(areaRepository.save(departamento));
    }
}
