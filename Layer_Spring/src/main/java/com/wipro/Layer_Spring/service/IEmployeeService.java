package com.wipro.Layer_Spring.service;

import com.wipro.Layer_Spring.pojo.Employee;
import java.util.List;

public interface IEmployeeService {
    int addEmployee(Employee emp);
    int updateEmployee(Employee emp);
    int deleteEmployeeById(int eid);
    Employee selectEmployeeById(int eid);
    List<Employee> selectAll();
}
