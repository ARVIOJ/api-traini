package com.trainibit.microservices.primer_API.controllers;

import com.trainibit.microservices.primer_API.dto.request.RoleRequest;
import com.trainibit.microservices.primer_API.dto.response.RoleResponse;
import com.trainibit.microservices.primer_API.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest roleRequest) {
        RoleResponse roleResponse = roleService.save(roleRequest);
        return ResponseEntity.ok(roleResponse);
    }
}
