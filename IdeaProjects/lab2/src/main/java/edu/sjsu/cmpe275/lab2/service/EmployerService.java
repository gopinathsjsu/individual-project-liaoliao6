package edu.sjsu.cmpe275.lab2.service;

import edu.sjsu.cmpe275.lab2.model.Employee;
import edu.sjsu.cmpe275.lab2.model.Employer;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface EmployerService extends CRUDService<Employer>{

    public boolean checkIfIfEmployerCreatedBeforeEmployee(List<Long> employees, List<Long> employers);
}


