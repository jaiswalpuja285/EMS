package com.code.spring.EMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.spring.EMS.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	    //add a method to sort by last name
		public List<Employee> findAllByOrderByFirstNameAsc();
		
		// search by name
		public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
