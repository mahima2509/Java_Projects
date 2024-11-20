package com.wipro.Layred_Hibernate.presentation;

import java.util.List;
import java.util.Scanner;
import com.wipro.Layred_Hibernate.pojo.Employee;
import com.wipro.Layred_Hibernate.service.EmployeeServiceImp;
import com.wipro.Layred_Hibernate.service.IEmployeeService;

public class Client {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        IEmployeeService service = new EmployeeServiceImp();
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
                    Employee emp = getEmployee();
                    int count1 = service.addEmployee(emp);
                    if (count1 > 0) {
                        System.out.println("Employee Added Successfully...");
                    } else {
                        System.err.println("Add Failed...");
                    }
                    break;

                case 2:
                    Employee emp1 = getEmployee();
                    int count2 = service.updateEmployee(emp1);
                    if (count2 > 0) {
                        System.out.println("Employee Updated Successfully...");
                    } else {
                        System.err.println("Update Failed...");
                    }
                    break;

                case 3:
                    System.out.println("Enter Eid to delete record");
                    int eid = scanner.nextInt();
                    int count3 = service.deleteEmployeeById(eid);
                    if (count3 > 0) {
                        System.out.println("Employee Deleted Successfully...");
                    } else {
                        System.err.println("Delete Failed...");
                    }
                    break;

                case 4:
                    System.out.println("Enter Eid to search record");
                    int eid1 = scanner.nextInt();
                    Employee employee = service.selectEmployeeById(eid1);
                    if (employee != null) {
                        System.out.println(employee);
                    } else {
                        System.err.println("Employee Not Found...");
                    }
                    break;

                case 5:
                    List<Employee> list = service.selectAll();
                    list.forEach(System.out::println);
                    break;

                case 6:
                    flag = false;
                    System.out.println("Thank you, visit again...");
                    break;

                default:
                    System.err.println("Invalid Option");
                    break;
            }
        }
    }

    public static Employee getEmployee() {
        System.out.println("Enter Eid:");
        int eid = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter EName:");
        String ename = scanner.nextLine();

        System.out.println("Enter Salary:");
        double salary = scanner.nextDouble();

        return new Employee(eid, ename, salary);
    }
}
