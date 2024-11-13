package com.paras.em.project.service;

import com.paras.em.project.model.Employee;

import java.util.List;

public interface EmpService {

    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(int id,Employee emp);
    void deleteEmployee(int id);

}
