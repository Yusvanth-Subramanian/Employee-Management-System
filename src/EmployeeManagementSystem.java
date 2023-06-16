import DTO.AddEmployeeDTO;
import Entity.Employee;
import Exceptions.EmployeeNotFoundException;
import Service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        boolean breakLoop = false;
        while(true) {

            if (breakLoop)
                break;

            System.out.println("Enter your choice : \n1.Add an Employee\n2.Get Employee details by id\n3.Update an Employee by id\n4.Delete an Employee By id\n5.Exit");
            int choice = s.nextInt();


            switch (choice){
                case 1:
                    while(true){
                        boolean exceptionOccured=false;
                        try{
                            System.out.print("Enter Employee id (In Integer) : ");
                            int empId = s.nextInt();
                            System.out.print("Enter Employee Name : ");
                            String name = s.next();
                            s.nextLine();
                            System.out.print("Enter Employee Designation : ");
                            String designation = s.next();
                            s.nextLine();
                            System.out.print("Enter Employee Salary : ");
                            double salary = s.nextDouble();
                            AddEmployeeDTO addEmployeeDTO = new AddEmployeeDTO(empId,name,designation,salary,employeeList);
                            employeeList = employeeService.addEmployee(addEmployeeDTO);

                        }
                        catch (Exception e){
                            exceptionOccured=true;
                            System.out.println("Enter valid details!!!");
                        }
                        if(!exceptionOccured)
                            break;
                    }
                    break;
                case 2:
                    while (true){
                        boolean exceptionOccured=false;
                        try{
                            System.out.print("Enter Employee id (In Integer) to see details : ");
                            int empId = s.nextInt();
                            Employee employee = employeeService.getEmployeeById(empId,employeeList);
                            System.out.println(employee);
                        }
                        catch (EmployeeNotFoundException e){
                            exceptionOccured=true;
                        }
                        catch (Exception e) {
                            exceptionOccured=true;
                            System.out.println("Retry with valid input.");
                        }
                        if(!exceptionOccured)
                            break;
                    }
                    break;
                case 3:
                    while (true){
                        boolean exceptionOccured=false;
                        try{
                            System.out.print("Enter Employee id (In Integer) to Update : ");
                            int empId = s.nextInt();
                            System.out.print("Enter Employee Name : ");
                            String name = s.next();
                            s.nextLine();
                            System.out.print("Enter Employee Designation : ");
                            String designation = s.next();
                            s.nextLine();
                            System.out.print("Enter Employee Salary : ");
                            double salary = s.nextDouble();

                            AddEmployeeDTO addEmployeeDTO = new AddEmployeeDTO(empId,name,designation,salary,employeeList);
                            employeeService.updateEmployee(addEmployeeDTO);
                        }
                        catch (EmployeeNotFoundException e){
                            exceptionOccured=true;
                        }
                        catch (Exception e) {
                            exceptionOccured=true;
                            System.out.println("Retry with valid input.");
                        }
                        if(!exceptionOccured)
                            break;
                    }
                    break;
                case 4:
                    while (true){
                        boolean exceptionOccured=false;
                        try{
                            System.out.print("Enter Employee id (In Integer) to delete: ");
                            int empId = s.nextInt();
                            employeeList=employeeService.deleteEmployeeById(empId,employeeList);
                        }
                        catch (EmployeeNotFoundException e){
                            exceptionOccured=true;
                        }
                        catch (Exception e) {
                            exceptionOccured=true;
                            System.out.println("Retry with valid input.");
                        }
                        if(!exceptionOccured)
                            break;
                    }
                    break;
                case 5:
                    breakLoop=true;
                    break;

            }

        }
    }
}

