package com.wipro.Layer_Spring.service;

import com.wipro.Layer_Spring.dao.IEmployeeDAO;
import com.wipro.Layer_Spring.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImp implements IEmployeeService {

    @Autowired
    private IEmployeeDAO dao;

    @Override
    public int addEmployee(Employee emp) {
        return dao.addEmployee(emp);
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
