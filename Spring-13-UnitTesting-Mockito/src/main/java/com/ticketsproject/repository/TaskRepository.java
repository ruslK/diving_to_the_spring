package com.ticketsproject.repository;

import com.ticketsproject.entities.Task;
import com.ticketsproject.entities.User;
import com.ticketsproject.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select count(t) from Task t where t.project.projectCode = :projectCode and t.status <> 'COMPLETE'")
    int totalNonCompletedTask(String projectCode);

    @Query(value = "select count(*) from tasks t " +
            "JOIN projects p on t.project_id = p.id " +
            "where p.project_code = ?1 and t.status = 'COMPLETE'", nativeQuery = true)
    int totalCompletedTask(String projectCode);

    List<Task> findAllByProjectProjectCode(String projectCode);

    List<Task> findAllByStatusIsNotAndAssignedEmployee(Status status, User user);

    List<Task> findAllByStatusIsAndAssignedEmployee(Status status, User user);

    List<Task> findAllByProjectAssignedManager(User manager);

    List<Task> findAllByAssignedEmployee(User user);
}
