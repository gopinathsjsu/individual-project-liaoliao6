package edu.sjsu.cmpe275.lab2.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.sjsu.cmpe275.lab2.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    public List<Employee> findByEmail(@Param("email") String email);
}
