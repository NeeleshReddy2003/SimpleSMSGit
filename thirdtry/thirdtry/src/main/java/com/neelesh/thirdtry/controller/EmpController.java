package com.neelesh.thirdtry.controller;

import com.neelesh.thirdtry.model.Employee;
import com.neelesh.thirdtry.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService es;

    @PostMapping("/employee/add")
    public Employee addEmployee(@RequestBody Employee e){
        return es.addEmployee(e);
    }

    @GetMapping("/employee/all")
    public List<Employee> getAllEmployees(){
        return es.getAllEmployees();
    }

    @GetMapping("/employee/{eid}")
    public Employee getEmployeeById(@PathVariable(name="eid") Long empid){
        return es.getEmployeeById(empid);
    }

    @PutMapping("/employee/update/{eid}")
    public Employee updateEmployee(@PathVariable(name="eid") Long empid){
        return es.updateEmp(empid);
    }

    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployeeById(@PathVariable(name="id") Long empid){
        es.deleteEmployeeById(empid);
    }

}
