package com.wipro.restapi.datajpa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.restapi.datajpa.entity.Employee;
import com.wipro.restapi.datajpa.service.IEmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;

	@PostMapping("/add")
	public Employee add(@RequestBody Employee emp) {

		return service.addEmployee(emp);

	}

	@PutMapping("/update")
	public Employee update(@RequestBody Employee emp) {

		return service.updateEmployee(emp);

	}

	@GetMapping("/getbyid/{eid}")
	public Employee getById(@PathVariable int eid) {

		return service.getEmployeeById(eid);

	}

	@DeleteMapping("/deletebyid/{eid}")
	public String deleteEmployeeById(@PathVariable int eid) {

		return service.deleteEmployeeById(eid);

	}

	@GetMapping("/getall")
	public List<Employee> getAllEmployees() {

		return service.getAllEmployees();

	}
	
	
	@GetMapping("/getbyename/{ename}")
	public Employee  getByEname(@PathVariable String ename) {
		
		return service.getByEname(ename);
		
	}
	
	@GetMapping("/get-sal-gt/{salary}")
	public List<Employee> getBySalGT(@PathVariable double salary) {

		return service.getBySalGT(salary);

	}
	
	
	@GetMapping("/getsorted/{salary}")
	public List<Employee> getBySortedSal(@PathVariable double salary) {

		return service.getBySortedSal(salary);

	}
	
	
	
	

}
