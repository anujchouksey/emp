package com.webservice.employee.emp.model;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @NotBlank
    private String emp_name;

    public Employee(Long id, String emp_name, String father_name, String address) {
        super();
        this.id = id;
        this.emp_name = emp_name;
        this.father_name = father_name;
        Address = address;
    }

    @NotBlank
    private String father_name;
    @NotBlank
    private String Address;
    public Employee(){
        super();
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
  }