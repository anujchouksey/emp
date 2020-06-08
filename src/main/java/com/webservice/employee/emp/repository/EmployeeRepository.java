package com.webservice.employee.emp.repository;
import com.webservice.employee.emp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;//patakro
import org.springframework.stereotype.Repository;
    @Repository
    public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    }

