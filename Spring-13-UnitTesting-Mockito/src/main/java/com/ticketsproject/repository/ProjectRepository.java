package com.ticketsproject.repository;

import com.ticketsproject.entities.Project;
import com.ticketsproject.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findAllByProjectCode(String projectCode);

    @Query("select p from Project p where p.assignedManager.id = :id")
    List<Project> findAllByManagerId(Long id);

    List<Project> findAllByProjectStatusIsNot(Status status);
}
