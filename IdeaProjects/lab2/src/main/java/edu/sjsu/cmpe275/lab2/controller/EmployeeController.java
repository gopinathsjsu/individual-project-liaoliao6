package edu.sjsu.cmpe275.lab2.controller;

import edu.sjsu.cmpe275.lab2.model.Employee;
import edu.sjsu.cmpe275.lab2.model.Employer;
import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Views;
import edu.sjsu.cmpe275.lab2.service.EmployeeService;



import jdk.nashorn.internal.scripts.JO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //@JsonView(Views.ProjectRelevantFieldsInEmployee.class)
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public ResponseEntity<?> addEmployee(
            @RequestParam(value = "id", required = true) long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "address", required = false) Address address,
            @RequestParam(value = "employer", required = true) Employer employer,
            @RequestParam(value = "manager", required = false) Employee manager,
            @RequestParam(value = "reports", required = false) Employee reports,
            @RequestParam(value = "collaborators", required = false) Employee collaborators
    ) throws JsonProcessingException {
        Employee employee = null;
        if (employeeService.getByEmail(email).size() == 0) {
            employee = new Employee(id, name, email, title);
            employee.setAddress(address);
            employee.setEmployer(employer);
            employee.setManager(manager);
            employee.setReports(Collections.emptyList());
            employee.setCollaborators(Collections.emptyList());
        }
        employeeService.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }


    //@JsonView(Views.ProjectRelevantFieldsInPassenger.class)
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(
            @PathVariable("id") Long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "address", required = false) Address address,
            @RequestParam(value = "employer", required = true) Employer employer,
            @RequestParam(value = "manager", required = false) Employee manager,
            @RequestParam(value = "reports", required = false) Employee reports,
            @RequestParam(value = "collaborators", required = false) Employee collaborators
    ) throws JsonProcessingException {

        Employee existingEmployee = employeeService.getById(id);
        if (existingEmployee == null) {
            String errMsg = "Sorry, the requested passenger with id " + id + " does not exist";
            //logger.debug("Sorry, the requested passenger with id " + id + " does not exist");
            //return ControllerUtil.sendBadRequest(errMsg, HttpStatus.NOT_FOUND);

        }

        List<Employee> employee = employeeService.getByEmail(email);
        if (employee.size() != 0 && employee.get(0).getId() != existingEmployee.getId()) {
            String errMsg = "Another passenger with the same phone number already exists.";
            //logger.debug("Another passenger with the same phone number already exists.");
            //return ControllerUtil.sendBadRequest(errMsg, HttpStatus.BAD_REQUEST);
        } else {
            existingEmployee.setName(name);
            existingEmployee.setEmail(email);
            existingEmployee.setTitle(title);
            existingEmployee.setAddress(address);
            existingEmployee.setEmployer(employer);
        }
            employeeService.save(existingEmployee);
            return new ResponseEntity<Employee>(existingEmployee, HttpStatus.OK);
        }
    }






