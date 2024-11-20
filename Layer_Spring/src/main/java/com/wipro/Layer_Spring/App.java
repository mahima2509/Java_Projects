package com.wipro.Layer_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.Layer_Spring.pojo.Employee;
import com.wipro.Layer_Spring.presentation.AppConfig;
import com.wipro.Layer_Spring.service.IEmployeeService;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        IEmployeeService employeeService = context.getBean(IEmployeeService.class);
        
        // Example of adding an employee
        Employee emp = new Employee(1, "John Doe", 50000);
        employeeService.addEmployee(emp);
        
        System.out.println("Employee Added: " + emp);
    }
}
