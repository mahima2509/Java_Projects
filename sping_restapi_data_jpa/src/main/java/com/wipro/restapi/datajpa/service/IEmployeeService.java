package com.wipro.restapi.datajpa.service;

import java.util.List;

import com.wipro.restapi.datajpa.entity.Employee;

public interface IEmployeeService {

	public Employee addEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public Employee getEmployeeById(int eid);

	public String deleteEmployeeById(int eid);
	
	public List<Employee>  getAllEmployees();
	
	public Employee  getByEname(String ename);
	
	public List<Employee>  getBySalGT(double salary);

	public List<Employee>  getBySortedSal(double salary);
	
}
