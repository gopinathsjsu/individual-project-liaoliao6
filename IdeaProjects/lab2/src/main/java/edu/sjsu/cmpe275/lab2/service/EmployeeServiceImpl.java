package edu.sjsu.cmpe275.lab2.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.model.Employee;
import edu.sjsu.cmpe275.lab2.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public Employee getById(Serializable id) {
        return employeeRepository.findOne((Long) id);
    }

    @Override
    public void delete(Serializable id) {
        employeeRepository.delete((Long) id);

    }

    @Override
    public List<Employee> getByEmail(Serializable email) {
        return employeeRepository.findByEmail((String) email);
    }
}
