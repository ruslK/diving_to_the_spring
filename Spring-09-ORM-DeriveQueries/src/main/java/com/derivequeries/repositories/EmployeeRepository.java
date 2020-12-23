package com.derivequeries.repositories;

import com.derivequeries.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findDistinctTop3BySalaryIsLessThan (int lessSalary);

    @Transactional
    List<Employee> findByEmailIsNull ();

}
