package edu.sjsu.cmpe275.lab2.controller;


import edu.sjsu.cmpe275.lab2.model.Employee;
import edu.sjsu.cmpe275.lab2.model.Employer;
import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Views;
import edu.sjsu.cmpe275.lab2.service.EmployerService;

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
@RequestMapping("/employer")

public class EmployerController {
    @Autowired
    EmployerService employerService;

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public ResponseEntity<?> addEmployer(
            @RequestParam(value = "id", required = true) long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "address", required = false) Address address
    ) throws JsonProcessingException {
        Employer employer = null;
        if (employerService.getById(id).size() == 0) {
            employer = new Employer(id, name, description);
            employer.setAddress(address);
        }
        employerService.save(employer);
        return new ResponseEntity<Employer>(employer, HttpStatus.CREATED);
    }


}
