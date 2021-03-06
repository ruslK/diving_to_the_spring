package com.ticketsproject.repository;

import com.ticketsproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName  (String username);

    @Query("select u from User u JOIN Role r on r.id = u.role.id " +
            "where r.description = 'Manager'")
    List<User> listOfManagers();

    @Query("select u from User u JOIN Role r on r.id = u.role.id " +
            "where r.description = 'Employee'")
    List<User> listOfEmployees();

    void deleteByUserName(String username);
}
