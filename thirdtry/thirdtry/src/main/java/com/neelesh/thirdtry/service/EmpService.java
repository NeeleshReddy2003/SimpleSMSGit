package com.neelesh.thirdtry.service;

import com.neelesh.thirdtry.model.Employee;
import com.neelesh.thirdtry.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository er;

    public Employee addEmployee(Employee e){
        return er.save(e);
    }

    public List<Employee> getAllEmployees(){
        return er.findAll();
    }

    public Employee getEmployeeById(Long eid){
        Optional<Employee> e=er.findById(eid);
        return e.orElse(null);
/*
        if(e.isPresent()){
            return e.get();
        }
        else return null;
*/
    }

    public Employee updateEmp(Long ens){
        Optional<Employee> e=er.findById(ens);
        if(e.isPresent())
        {
            Employee emp=e.get();
            emp.setEmpAge(25L);
            emp.setEmpName("Neelesh");
            //emp.setEmpId(7L);
            return er.save(emp);
        }
        else{
            return null;
        }
    }

    public void deleteEmployeeById(Long empid){
        er.deleteById(empid);
    }
}
