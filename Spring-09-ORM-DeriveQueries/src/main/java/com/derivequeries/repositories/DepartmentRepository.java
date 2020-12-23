package com.derivequeries.repositories;

import com.derivequeries.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByDepartment (String department);
    List<Department> findByDivision (String division);
    List<Department> findByDivisionIs (String division);
    List<Department> findByDivisionEquals (String division);
    List<Department> findByDivisionLike (String patten);
    List<Department> findByDivisionEndingWith (String patten);
    List<Department> findDistinctTop3ByDivisionContaining (String patten);


}
