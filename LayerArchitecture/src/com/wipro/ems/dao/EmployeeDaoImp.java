package com.wipro.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.wipro.dao.DBUtil;
import com.wipro.ems.pojo.Employee;

public class EmployeeDaoImp implements IEmployeeDAO {

	Connection conn = DBUtil.getDBConnection();

	@Override
	public int addEmployee(Employee emp) {
		// jdbc

		String insertQuery = "insert into Employees values(?,?,?)";
		int count = 0;
		try {

			PreparedStatement pstmt = conn.prepareStatement(insertQuery);

			pstmt.setInt(1, emp.getEid());
			pstmt.setString(2, emp.getEname());
			pstmt.setDouble(3, emp.getSalary());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int updateEmployee(Employee emp) {

		// jdbc for update query
		
	    String updateQuery = "UPDATE Employees SET ename = ?, salary = ? WHERE eid = ?";

	    int count = 0;
	    try {
	        // Prepare the SQL statement
	        PreparedStatement pstmt = conn.prepareStatement(updateQuery);

	        // Set the parameters for the query
	        pstmt.setString(1, emp.getEname());  // Set the employee name
	        pstmt.setDouble(2, emp.getSalary()); // Set the employee salary
	        pstmt.setInt(3, emp.getEid());       // Set the employee ID to identify which record to update

	        // Execute the update query
	        count = pstmt.executeUpdate();

	    } catch (SQLException e) {
	        // Handle any SQL exceptions
	        e.printStackTrace();
	    }

	   return count; // Return the number of records updated
	}


		//return 0;
	//}

	@Override
	public int deleteEmployeeById(int eid) {

		String deleteQuery = "delete from Employees where eid = ?";

		int count = 0;
		try {

			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);

			pstmt.setInt(1, eid);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public List<Employee> selectAll() {
	
			List<Employee> list =	new ArrayList<Employee>();
		
		try {

			String selectAllQuery = "select eid,ename,salary from Employees";
			
			PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

		Employee	emp = new Employee(rs.getInt("eid"), rs.getString("ename"), rs.getDouble("salary"));
		list.add(emp);
				
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

}
