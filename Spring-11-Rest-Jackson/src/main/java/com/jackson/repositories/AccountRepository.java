package com.jackson.repositories;

import com.jackson.entities.Account;
import com.jackson.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByAgeGreaterThan(int age);

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findAllByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAllByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findAllByRole(Roles role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findAllByAgeBetween(Integer age1, Integer age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String startAddress);

    //Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAge();


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select a from Account a")
    List<Account> getAllAccount();

    //Write a JPQL query to list all admin accounts
    @Query("select a from Account a where a.role = 'Admin'")
    List<Account> getAllAdmins();

    //Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age")
    List<Account> getAccountSortedByAge();


    // ------------------- Native QUERIES ------------------- //
    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age < :age", nativeQuery = true)
    List<Account> getAccountByAgeLowerThen(Integer age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details where name ILIKE concat('%',?1,'%') OR country ILIKE concat('%', ?1, '%') OR address ILIKE concat('%', ?1, '%') OR state ILIKE concat('%', ?1, '%')",
            nativeQuery = true)
    List<Account> getSpecificAccount(String pattern);

    //Write a native query to read all accounts with an age lower than a specific value
    @Query (value = "SELECT * from account_details WHERE age < :Age", nativeQuery = true)
    List<Account> getAccountByAge(Integer Age);
}
