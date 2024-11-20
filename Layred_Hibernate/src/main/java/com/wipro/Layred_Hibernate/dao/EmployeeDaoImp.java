package com.wipro.Layred_Hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.wipro.Layred_Hibernate.pojo.Employee;
//import com.wipro.Layred_Hibernate.util.HibernateUtil;

public class EmployeeDaoImp implements IEmployeeDAO {

    @Override
    public int saveEmployee(Employee emp) {
        Transaction transaction = null;
        int employeeId = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employeeId = (int) session.save(emp); // save() method returns Serializable
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return employeeId;
    }

    @Override
    public int updateEmployee(Employee emp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(emp); // Hibernate predefined update method
            transaction.commit();
            return 1; // Success
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return 0; // Failure
    }

    @Override
    public int deleteEmployeeById(int eid) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee emp = session.get(Employee.class, eid);
            if (emp != null) {
                session.delete(emp); // Hibernate predefined delete method
                transaction.commit();
                return 1; // Success
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return 0; // Failure
    }

    @Override
    public Employee selectEmployeeById(int eid) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, eid); // get() method for fetching by ID
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> selectAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Employee> query = session.createQuery("from Employee", Employee.class); // HQL query
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
