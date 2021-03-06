package com.orm2.bootstrap;

import com.orm2.Gender;
import com.orm2.entity.Department;
import com.orm2.entity.Employee;
import com.orm2.entity.Region;
import com.orm2.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    EmployeeRepository employeeRepository;

    public DataGenerator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Department d1 = new Department("Sports", "Outdoors");
        Department d2 = new Department("Tools", "Hardware");
        Department d3 = new Department("Clothing", "Home");
        Department d4 = new Department("Phones & Tablets", "Electronics");
        Department d5 = new Department("Computers", "Electronics");
//        departmentRepository.saveAll(new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5)));

        Region r1 = new Region("Southwest", "United States");
        Region r2 = new Region("'Northeast", "United States");
        Region r3 = new Region("'Central", "Asia");
        Region r4 = new Region("Quebec", "Canada");
        Region r5 = new Region("East Asia", "Asia");

        Employee e1 = new Employee("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006, 04, 20), Gender.Female, 154864);
        Employee e2 = new Employee("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009, 01, 26), Gender.Female, 56752);
        Employee e3 = new Employee("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010, 05, 17), Gender.Female, 95313);
        Employee e4 = new Employee("Avrom", "Rowantree", null, LocalDate.of(2014, 03, 02), Gender.Male, 119764);
        Employee e5 = new Employee("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003, 01, 14), Gender.Male, 55307);

        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e4.setDepartment(d4);
        e5.setDepartment(d4);

        e1.setRegion(r1);
        e2.setRegion(r2);
        e3.setRegion(r3);
        e4.setRegion(r4);
        e5.setRegion(r5);

        employeeRepository.saveAll(new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5)));

    }
}
