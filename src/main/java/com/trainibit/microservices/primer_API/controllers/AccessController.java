package com.trainibit.microservices.primer_API.controllers;

import com.trainibit.microservices.primer_API.dto.request.AuthRequest;
import com.trainibit.microservices.primer_API.entity.Employee;
import com.trainibit.microservices.primer_API.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController //anotaciones
@RequestMapping("/api/v2/")
public class AccessController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest) {
        String emailId = authRequest.getUsername();
        String password = authRequest.getPassword();
        Employee employee = employeeRepository.findByEmailAddressAndPassword(emailId, password);

        if (employee == null) {
            return ResponseEntity.ok("Usuario o password incorrecto");
        } else {
            employee.setLastAccess(LocalDate.now());
            employeeRepository.save(employee);
            return ResponseEntity.ok("Token");
        }
    }

}
