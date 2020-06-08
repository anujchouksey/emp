package com.webservice.employee.emp.Controller;

import com.webservice.employee.emp.model.Employee;
import com.webservice.employee.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/emp")
    public List<Employee> getAllNotes() {
        return employeeRepository.findAll();
    }

    @PostMapping("/emp")
    public Employee createNote(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/emp/{id}")
    public Employee getNoteById(@PathVariable(value = "id") Long employeeID) {

        return employeeRepository.findById(employeeID)
                .orElseThrow(() -> new RuntimeException("Emp ID not found "));
    }
    @PutMapping("/emp/{id}")
    public Employee updateNote(@PathVariable(value = "id") Long employeeId,
                           @Valid @RequestBody Employee bookDetails){

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Emp ID not found "));

        employee.setId(bookDetails.getId());
        employee.setEmp_name(bookDetails.getEmp_name());
        employee.setAddress(bookDetails.getAddress());

        Employee  updatedEmp = employeeRepository.save(employee);

        return updatedEmp;
    }


    @DeleteMapping("/emp/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long employeeId )  {
        Employee emp1 = employeeRepository.findById(employeeId)
                .orElseThrow(() ->  new RuntimeException("Emp ID not found "));

        employeeRepository.delete(emp1);

        return ResponseEntity.ok().build();
    }

}
