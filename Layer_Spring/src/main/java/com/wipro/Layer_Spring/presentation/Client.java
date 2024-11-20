package com.wipro.Layer_Spring.presentation;

import com.wipro.Layer_Spring.pojo.Employee;  // Import correct Employee class
import com.wipro.Layer_Spring.service.IEmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Client {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // Ensure AppConfig is correct
        IEmployeeService service = context.getBean(IEmployeeService.class); // Get the service bean

        boolean flag = true;
        System.out.println("******* WELCOME TO EMS *******");

        while (flag) {
            System.out.println("1. ADD EMPLOYEE");
            System.out.println("2. UPDATE EMPLOYEE");
            System.out.println("3. DELETE EMPLOYEE BY ID");
            System.out.println("4. DISPLAY EMPLOYEE BY ID");
            System.out.println("5. DISPLAY ALL EMPLOYEES");
            System.out.println("6. EXIT");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Employee emp = getEmployee(); // Get employee details from user
                    int count1 = service.addEmployee(emp); // Add employee
                    System.out.println(count1 > 0 ? "Employee Added Successfully..." : "Add Failed...");
                    break;

                case 2:
                    Employee emp1 = getEmployee(); // Get updated employee details
                    service.updateEmployee(emp1); // Update employee
                    System.out.println("Employee Updated Successfully");
                    break;

                case 3:
                    System.out.println("Enter Eid to delete record:");
                    int eid = scanner.nextInt();
                    int count2 = service.deleteEmployeeById(eid); // Delete employee by ID
                    System.out.println(count2 > 0 ? "Employee Deleted Successfully..." : "Delete Failed...");
                    break;

                case 4:
                    System.out.println("Enter Eid to search record:");
                    int eid1 = scanner.nextInt();
                    Employee employee = service.selectEmployeeById(eid1); // Select employee by ID
                    System.out.println(employee != null ? employee : "Employee Not Found");
                    break;

                case 5:
                    List<Employee> list = service.selectAll(); // Get all employees
                    list.forEach(System.out::println); // Print all employees
                    break;

                case 6:
                    System.out.println("THANK YOU");
                    flag = false; // Exit the loop
                    break;

                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }

    // Method to collect employee details from user input
    private static Employee getEmployee() {
        System.out.println("Enter Eid:");
        int eid = scanner.nextInt();
        System.out.println("Enter Name:");
        String ename = scanner.next();
        System.out.println("Enter Salary:");
        double salary = scanner.nextDouble();
        return new Employee(eid, ename, salary); // Return Employee object
    }
}
