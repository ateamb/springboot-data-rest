package com.javabanters.springboot.demo.service;

import com.javabanters.springboot.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
