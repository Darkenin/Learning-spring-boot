package com.lsio.springboot.services;

import java.util.List;

import com.lsio.springboot.Pojos.EmployeeRequest;
import com.lsio.springboot.entities.Employee;
import com.lsio.springboot.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService(){

    }

    public List<Employee> saveAllEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> findAllEmployeesByIds(List<Integer> ids){
        return employeeRepository.findAllById(ids);
    }

    public Employee findEmployeeById(int id){
        return employeeRepository.findById(id);
    }

    public List<Employee> findEmployeesByName(String employeename){
        return employeeRepository.findByEmployeename(employeename);
    }
}
