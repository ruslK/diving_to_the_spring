package com.derivequeries;

import com.derivequeries.repositories.DepartmentRepository;
import com.derivequeries.repositories.EmployeeRepository;
import com.derivequeries.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivequeriesApplication {

	@Autowired
	RegionRepository regionRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DerivequeriesApplication.class, args);
	}

	@PostConstruct
	public void testRegions() {
		System.out.println(regionRepository.findRegionByCountry("Canada").toString());
		System.out.println(regionRepository.findByCountry("Canada").toString());
		System.out.println(regionRepository.findDistinctByCountry("Canada").toString());
		System.out.println(regionRepository.findByCountryContaining("United").toString());
		System.out.println(regionRepository.findByCountryContainingOrderByCountry("United").toString());
		System.out.println(regionRepository.findByCountryContainingOrderByCountryDesc("United").toString());
		System.out.println(regionRepository.findTop1ByCountry("United").toString());
		System.out.println(regionRepository.findTop2ByCountry("United").toString());
		System.out.println(regionRepository.findTop3ByCountry("United").toString());

		System.out.println(employeeRepository.findDistinctTop3BySalaryIsLessThan(45));
		System.out.println(employeeRepository.findByEmailIsNull());
	}
}
