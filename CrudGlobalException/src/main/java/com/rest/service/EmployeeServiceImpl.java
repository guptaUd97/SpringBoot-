package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.Exception.NoSuchElementPresent;
import com.rest.entity.Employee;
import com.rest.repositries.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee saveEmployee(Employee employee) {

		if (employee.getEmpName() != null && !employee.getEmpName().isEmpty()) {
			return employeeRepo.save(employee);
		} else {
			throw new NoSuchElementPresent(601, "Name is not Present", false);
		}
	}

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> list = employeeRepo.findAll();
		if (list.isEmpty()) {
			throw new NoSuchElementPresent(601, "Employee List is not Present", false);
		}

		return list;

	}

	@Override
	public Employee findEmployeeById(Integer empId) {
		Optional<Employee> byId = employeeRepo.findById(empId);
		if (byId.isPresent()) {
			return byId.get();
		} else {
			throw new NoSuchElementPresent(602, empId + "-Employee Id is not Present in DB ", false);
		}

	}

	@Override
	public void deleteEmployee(Integer empId) {

		Optional<Employee> byId = employeeRepo.findById(empId);
		if (byId.isPresent()) {
			employeeRepo.deleteById(empId);
		} else {
			throw new NoSuchElementPresent(602, empId + "-Employee Id is not Present in DB", false);
		}
	}

	public Employee updateEmpData(Employee employee, Integer empId) {
		Employee existingEmployee = findEmployeeById(empId);

		if (employee.getEmpName() !=null) {
			existingEmployee.setEmpName(employee.getEmpName());
		} else if (employee.getEmpDepartment()!=null) {
			existingEmployee.setEmpDepartment(employee.getEmpDepartment());

		} else if (employee.getEmpEmail()!=null) {
			existingEmployee.setEmpEmail(employee.getEmpEmail());
		} else if (employee.getEmpSalary() !=null) {
			existingEmployee.setEmpSalary(employee.getEmpSalary());
		}

		return employeeRepo.save(existingEmployee);
	}

}
