package edu.sjsu.cmpe275.lab2.model;

import org.json.JSONObject;

import javax.persistence.*;
import java.util.List;



@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String title;
    private Address address;
    private Employer employer;
    private Employee manager;
    private List<Employee> reports;
    private List<Employee> collaborators;

    public Employee(long id, String s, String name, String email){

    }

    public Employee(long id, String name, String email, String title, Address address, Employer employer, Employee manager,
                    List<Employee> reports, List<Employee> collaborators) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.title = title;
        this.address = address;
        this.employer = employer;
        this.manager = manager;
        this.reports = reports;
        this.collaborators = collaborators;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getReports() {
        return reports;
    }

    public void setReports(List<Employee> reports) {
        this.reports = reports;
    }

    public List<Employee> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<Employee> collaborators) {
        this.collaborators = collaborators;
    }

}
