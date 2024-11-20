package com.wipro.ems.testings;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.wipro.ems.pojo.Employee;
import com.wipro.ems.service.EmployeeServiceImp;
import com.wipro.ems.service.IEmployeeService;

class EmployeeServiceImpTest {
	
	
	 static  IEmployeeService service;
	 
	 @BeforeAll
	 public static void beforeAll() {
		 
		 service = new EmployeeServiceImp();
		 
	 }
	
	

	 @Test
	 void testAddEmployee() {
	     Employee emp = new Employee(109, "Messi", 95000); // Use new ID and name
	     int count = service.addEmployee(emp);
	     assertEquals(1, count, "Employee should be added successfully");
	 }

	 @Test
	 void testUpdateEmployee() {
	     // Add a new employee first
	     Employee emp = new Employee(110, "Neymar", 85000); // Use new ID and name
	     service.addEmployee(emp);

	     // Update the employee's salary
	     emp.setSalary(90000);
	     int count = service.updateEmployee(emp);
	     assertEquals(1, count, "Employee should be updated successfully");
	 }

	 @Test
	 void testDeleteEmployeeById() {
	     int empId = 111; // Use a new ID
	     Employee emp = new Employee(empId, "Salah", 80000); // Add this employee first
	     service.addEmployee(emp);

	     int count = service.deleteEmployeeById(empId);
	     assertEquals(1, count, "Employee should be deleted successfully");
	 }

	 @Test
	 void testSelectEmployeeById() {
	     int empId = 112; // Use a new ID
	     Employee emp = new Employee(empId, "Mbappe", 120000); // Add this employee first
	     service.addEmployee(emp);

	     Employee retrievedEmp = service.selectEmployeeById(empId);
	     assertEquals("Mbappe", retrievedEmp.getEname(), "Employee name should be Mbappe");
	     assertEquals(120000, retrievedEmp.getSalary(), "Employee salary should be 120000");
	 }

	 @Test
	 void testSelectAll() {
	     // Ensure there are employees in the database
	     List<Employee> employees = service.selectAll();
	     assertTrue(employees.size() > 0, "There should be at least one employee in the list");
	 }
}