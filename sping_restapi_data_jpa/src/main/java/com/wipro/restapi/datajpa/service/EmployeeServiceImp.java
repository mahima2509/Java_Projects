package com.wipro.restapi.datajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.restapi.datajpa.entity.Employee;
import com.wipro.restapi.datajpa.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	 private  EmployeeRepository repo;
	
	
	@Override
	public Employee addEmployee(Employee emp) {


		return repo.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		
		return repo.save(emp);
	}

	@Override
	public Employee getEmployeeById(int eid) {
		
		return repo.findById(eid).orElse(null);
	}

	@Override
	public String deleteEmployeeById(int eid) {
				repo.deleteById(eid);
				
		return "Record deleted for Eid "+eid;		
				
	}

	@Override
	public List<Employee> getAllEmployees() {
				
		return repo.findAll();
	}

	@Override
	public Employee getByEname(String ename) {


		return repo.findByEname(ename);
	}

	@Override
	public List<Employee> getBySalGT(double salary) {
		// TODO Auto-generated method stub
		return repo.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> getBySortedSal(double salary) {
		// TODO Auto-generated method stub
		return repo.findAllSorted(salary);
	}

}
