package com.trainibit.microservices.primer_API.controllers;

import com.trainibit.microservices.primer_API.dto.request.EmployeeRequest;
import com.trainibit.microservices.primer_API.dto.response.EmployeeResponse;
import com.trainibit.microservices.primer_API.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // get all employees
    @GetMapping("/employees")
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.buscarTodos();
    }

    @GetMapping("/employees/{uuid}")
    public ResponseEntity<EmployeeResponse> getEmployeeByUuid(@PathVariable UUID uuid){
        EmployeeResponse employeeResponse = employeeService.getByUuid(uuid);
        return ResponseEntity.ok(employeeResponse);
    }

    /*
    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse = employeeService.save(employeeRequest);
        return ResponseEntity.ok(employeeResponse);
    }
    */
    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse = employeeService.save(employeeRequest);
        return ResponseEntity.ok(employeeResponse);
    }

    @PutMapping("/employees/{uuid}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable UUID uuid, @RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse = employeeService.update(uuid, employeeRequest);
        return ResponseEntity.ok(employeeResponse);
    }

    // delete employee rest api
    @DeleteMapping("/employees/{uuid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable UUID uuid){
        employeeService.delete(uuid);
        return ResponseEntity.ok("Se elimino el registro en la DB");
    }

}
