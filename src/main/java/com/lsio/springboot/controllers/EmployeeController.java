package com.lsio.springboot.controllers;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;


import com.lsio.springboot.entities.Employee;
import com.lsio.springboot.repositories.EmployeeRepository;
import com.lsio.springboot.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees/")
@Validated
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("addemployees")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees)
    {
        return employeeService.saveAllEmployees(employees);
    }

    @PostMapping("addemployee")
    public Employee addEmployee(@Valid @RequestBody Employee employee)
    {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("allemployees")
    public List<Employee> getAllEmployees()
    {
        return employeeService.findAllEmployees();
    }

    @GetMapping("employeeswithname")
    public List<Employee> getAllEmployeesWithName(@RequestParam String employeename)
    {
        return employeeService.findEmployeesByName(employeename);
    }

    @GetMapping("employeebyid")
    public Employee getEmployeeById(@RequestParam @Min(value =1, message = "Employee ID should be greater than 0") int id)
    {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("employeesbyids")
    public List<Employee> getEmployeesByIds(@RequestBody List<Integer> ids)
    {
        return employeeService.findAllEmployeesByIds(ids);
    }

    @GetMapping("empbydeptandage")
    public List<Employee> getEmpByDeptAndAge(@RequestParam String department, @RequestParam int age)
    {
        return employeeRepository.findByDepartmentAndAgeGreaterThanEqual(department, age);
    }

    @GetMapping("employeesbyname")
    public List<Employee> getEmployeesByName(@RequestParam int age)
    {
        return employeeRepository.findTop5ByAge(age);
    }

    
}
