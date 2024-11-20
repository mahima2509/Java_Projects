package com.wipro.Layred_Hibernate.service;

import java.util.List;
import com.wipro.Layred_Hibernate.pojo.Employee;

public interface IEmployeeService {
    int addEmployee(Employee emp);
    int updateEmployee(Employee emp);
    int deleteEmployeeById(int eid);
    Employee selectEmployeeById(int eid);
    List<Employee> selectAll();
}

