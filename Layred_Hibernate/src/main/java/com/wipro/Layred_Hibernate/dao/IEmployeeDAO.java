package com.wipro.Layred_Hibernate.dao;

import java.util.List;
import com.wipro.Layred_Hibernate.pojo.Employee;

public interface IEmployeeDAO {
    int saveEmployee(Employee emp);
    int updateEmployee(Employee emp);
    int deleteEmployeeById(int eid);
    Employee selectEmployeeById(int eid);
    List<Employee> selectAll();
}
