package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.exception.CustomException;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        if (employeeRepository.findAll().isEmpty()) {
            throw new CustomException("No employee in database.");
        } else return employeeRepository.findAll();
    }

    public Optional<Employee> getById(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            return employeeRepository.findById(id);
        } else throw new CustomException("No employee matches with the given ID");
    }

    public String deleteById(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee with ID: " + id + " is Deleted Successfully!!";
        } else throw new CustomException("No employee matches with the given ID");
    }

    public Employee editEmployee(EmployeeDTO employeeDTO, int id) {
        if (employeeRepository.findById(id).isPresent()) {
            Employee employee1 = new Employee(id, employeeDTO);
            Employee employee = employeeRepository.save(employee1);
            return employee;
        } else throw new CustomException("No employee matches with the given ID");
    }
}