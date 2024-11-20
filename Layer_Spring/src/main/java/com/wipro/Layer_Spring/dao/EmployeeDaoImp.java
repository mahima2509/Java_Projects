package com.wipro.Layer_Spring.dao;

import com.wipro.Layer_Spring.pojo.Employee;
//import com.wipro.Layer_Spring.util.DBUtil;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImp implements IEmployeeDAO {

    private Connection conn = DBUtil.getDBConnection();

    @Override
    public int addEmployee(Employee emp) {
        String insertQuery = "insert into Employees values(?,?,?)";
        int count = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, emp.getEid());
            pstmt.setString(2, emp.getEname());
            pstmt.setDouble(3, emp.getSalary());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateEmployee(Employee emp) {
        String updateQuery = "UPDATE Employees SET ename = ?, salary = ? WHERE eid = ?";
        int count = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, emp.getEname());
            pstmt.setDouble(2, emp.getSalary());
            pstmt.setInt(3, emp.getEid());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deleteEmployeeById(int eid) {
        String deleteQuery = "delete from Employees where eid = ?";
        int count = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, eid);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Employee selectEmployeeById(int eid) {
        String selectOne = "select * from Employees where eid = ?";
        Employee emp = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(selectOne);
            pstmt.setInt(1, eid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                emp = new Employee(rs.getInt("eid"), rs.getString("ename"), rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> list = new ArrayList<>();
        try {
            String selectAllQuery = "select eid,ename,salary from Employees";
            PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt("eid"), rs.getString("ename"), rs.getDouble("salary"));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
