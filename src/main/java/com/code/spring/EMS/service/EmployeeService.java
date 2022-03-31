package com.code.spring.EMS.service;

import java.util.List;

import com.code.spring.EMS.entity.Employee;


public interface EmployeeService {
	
	    public List<Employee> findAll();
		
		public Employee findById(int theId);
		
		public void save(Employee theEmployee);
		
		public void deleteById(int theId);
		
		public List<Employee> searchBy(String theName);

}
