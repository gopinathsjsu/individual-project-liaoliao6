package edu.sjsu.cmpe275.lab2.service;

import java.io.Serializable;
import java.util.List;

import edu.sjsu.cmpe275.lab2.model.Employee;
import edu.sjsu.cmpe275.lab2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.model.Employer;
import edu.sjsu.cmpe275.lab2.repository.EmployerRepository;

@Service
public class EmployerServiceImpl implements EmployerService{
    @Autowired
    private EmployerRepository employerRepository;


    @Override
    public Employer save(Employer entity) {
        return employerRepository.save(entity);
    }

    @Override
    public Employer getById(Serializable id) {
        return employerRepository.findOne((Long) id);
    }

    @Override
    public void delete(Serializable id) {
        employerRepository.delete((Long) id);
    }

    @Override
    public boolean checkIfIfEmployerCreatedBeforeEmployee(List<Long> employees, List<Long> employers) {
        return false;
    }
}
