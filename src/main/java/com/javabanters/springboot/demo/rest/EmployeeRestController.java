package com.javabanters.springboot.demo.rest;

import com.javabanters.springboot.demo.dao.EmployeeDAO;
import com.javabanters.springboot.demo.entity.Employee;
import com.javabanters.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if( employee == null) {
            throw new RuntimeException("Employee id not found"+ id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("employees/{id}")
    public String delete(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if( employee == null) {
            throw new RuntimeException("Employee id not found"+ id);
        }
        employeeService.deleteById(id);
        return "Deleted employee with id " +id;
    }



}
