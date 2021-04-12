package edu.sjsu.cmpe275.lab2.service;

import java.util.List;


import java.io.Serializable;
import java.util.List;

import edu.sjsu.cmpe275.lab2.model.Employee;


public interface EmployeeService extends CRUDService<Employee> {

    public List<Employee> getByEmail(Serializable email);
}
