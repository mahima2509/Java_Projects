package com.wipro.Layred_Hibernate.service;

import java.util.List;
import com.wipro.Layred_Hibernate.dao.EmployeeDaoImp;
import com.wipro.Layred_Hibernate.dao.IEmployeeDAO;
import com.wipro.Layred_Hibernate.pojo.Employee;

public class EmployeeServiceImp implements IEmployeeService {

    private IEmployeeDAO dao;

    public EmployeeServiceImp() {
        dao = new EmployeeDaoImp();
    }

    @Override
    public int addEmployee(Employee emp) {
        return dao.saveEmployee(emp);
    }

    @Override
    public int updateEmployee(Employee emp) {
        return dao.updateEmployee(emp);
    }

    @Override
    public int deleteEmployeeById(int eid) {
        return dao.deleteEmployeeById(eid);
    }

    @Override
    public Employee selectEmployeeById(int eid) {
        return dao.selectEmployeeById(eid);
    }

    @Override
    public List<Employee> selectAll() {
        return dao.selectAll();
    }
}
