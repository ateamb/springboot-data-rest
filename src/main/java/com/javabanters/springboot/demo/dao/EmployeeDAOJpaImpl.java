package com.javabanters.springboot.demo.dao;

import com.javabanters.springboot.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOJpaImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {

    TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
    List<Employee> employees = theQuery.getResultList();
    return employees;
  }

  @Override
  public Employee findByID(int id) {
    Employee employee = entityManager.find(Employee.class, id);
    return employee;
  }

  @Override
  public Employee save(Employee employee) {
    Employee dbEmployee = entityManager.merge(employee);
    return dbEmployee;
  }

  @Override
  public void deleteById(int id) {
    Employee employee = entityManager.find(Employee.class, id);
    entityManager.remove(employee);
  }
}
