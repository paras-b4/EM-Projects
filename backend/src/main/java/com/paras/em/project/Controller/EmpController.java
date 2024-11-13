package com.paras.em.project.Controller;

import com.paras.em.project.model.Employee;

import com.paras.em.project.service.EmpServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000/")
@RestController
public class EmpController {

    @Autowired
    private final EmpServiceImp service;
    public EmpController(EmpServiceImp service)
    {
        this.service=service;
    }


    @GetMapping("/employees")
    public List<Employee> getAllEmployee()
    {
        return service.getAllEmployee();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id)
    {
        return service.getEmployeeById(id);
    }
    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee emp)
    {
          service.addEmployee(emp);

    }
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id ,@RequestBody Employee emp)
    {

        service.updateEmployee(id,emp);
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee( @PathVariable int id )
    {
        service.deleteEmployee(id);
    }
}

