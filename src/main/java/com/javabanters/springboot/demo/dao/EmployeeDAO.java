package com.javabanters.springboot.demo.dao;

import com.javabanters.springboot.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findByID(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
