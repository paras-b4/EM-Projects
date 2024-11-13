package com.paras.em.project.service;

import com.paras.em.project.Repository.EmpRepository;
import com.paras.em.project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    private EmpRepository repo;

//    List<Employee> employee = new ArrayList<Employee>(Arrays.asList(
//            new Employee(1, "paras", "paras@gmail.com", 9868),
//            new Employee(2, "dev", "dev@gmail.com", 87004)));


    public List<Employee> getAllEmployee() {
        // return employee;
        return repo.findAll();
    }

    public Employee getEmployeeById(int id) {

//            return  employee.stream()
//                    .filter(p-> p.getId()== id)
//                    .findFirst().orElse(new Employee(0,null,null,0));
        return repo.findById(id).get();
    }

    public void addEmployee(Employee emp) {
        repo.save(emp);
    }


    public void deleteEmployee(int id) {
//            int index = 0;
//            for (int i = 0; i < employee.size(); i++) {
//                if (employee.get(i).getId() == id) {
//                    index = i;
//                }
//            }employee.remove(index);
//        }
        repo.deleteById(id);}

        public void updateEmployee(int id,Employee emp)
       {
//            int index = 0;
//            for (int i = 0; i < employee.size(); i++) {
//                if (employee.get(i).getId() == emp.getId()) {
//
//
//                    index = i;
//                }
//                employee.set(index, emp);
//            }

           repo.save(emp);



//
        }



}



