package com.trainibit.microservices.primer_API.controllers;

import com.trainibit.microservices.primer_API.dto.request.DepartamentoRequest;
import com.trainibit.microservices.primer_API.dto.response.DepartamentoResponse;
import com.trainibit.microservices.primer_API.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping("/area/")
    public ResponseEntity<DepartamentoResponse> createArea(@RequestBody DepartamentoRequest departamentoRequest) {
        DepartamentoResponse departamentoResponse = departamentoService.save(departamentoRequest);
        return ResponseEntity.ok(departamentoResponse);
    }
}
