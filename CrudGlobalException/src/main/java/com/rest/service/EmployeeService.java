package com.rest.service;

import java.util.List;

import com.rest.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> findAllEmployee();

	public Employee findEmployeeById(Integer empId);

	public void deleteEmployee(Integer empId);
	
	public Employee updateEmpData(Employee employee, Integer empId);

}
