package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Employee;
import com.rest.service.EmployeeService;
import com.rest.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/crud")
public class EmployeeController {

	@Autowired
	private EmployeeService serviceImpl;

	@PostMapping("/save")
	public ResponseEntity<?> saveEmployeeData(@RequestBody Employee employee) {

		Employee saveEmployee = serviceImpl.saveEmployee(employee);
		return new ResponseEntity<Employee>(saveEmployee, HttpStatus.CREATED);

	}

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmp() {
		List<Employee> allEmployee = serviceImpl.findAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee, HttpStatus.OK);
	}

	@GetMapping("/emp/{empId}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("empId") Integer empId) {
		Employee employeeById = serviceImpl.findEmployeeById(empId);
		return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmp(@PathVariable Integer empId) {
		serviceImpl.deleteEmployee(empId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("update")
	ResponseEntity<Employee> updateEmp(@RequestBody Employee employee) {
		Employee saveEmployee = serviceImpl.saveEmployee(employee);
		return new ResponseEntity<Employee>(saveEmployee, HttpStatus.CREATED);
	}
	
	@PatchMapping("update/{empId}")
	ResponseEntity<Employee> updateEmpFewData(@RequestBody Employee employee, @PathVariable Integer empId){
		Employee updateEmpData = serviceImpl.updateEmpData(employee, empId);
		return new ResponseEntity<Employee>(updateEmpData, HttpStatus.ACCEPTED);
	}
}
