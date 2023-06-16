package Service;

import DTO.AddEmployeeDTO;
import Entity.Employee;
import Exceptions.EmployeeAlreadyExistsException;
import Exceptions.EmployeeNotFoundException;
import Exceptions.NegativeSalaryException;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> addEmployee(AddEmployeeDTO employeeDTO) throws EmployeeAlreadyExistsException, NegativeSalaryException {
        boolean employeeAlreadyExists = false;
        for(Employee employee:employeeDTO.getListOfEmployees()){
            if(employee.getEmployeeId()==employeeDTO.getEmployeeId()){
                employeeAlreadyExists=true;
                throw new EmployeeAlreadyExistsException("Employee Already exists with the given id . ");
            }
        }
        if(employeeDTO.getEmployeeSalary()<0)
            throw new NegativeSalaryException("Salary cannot be in negative.");
        Employee employee = new Employee(employeeDTO.getEmployeeId(), employeeDTO.getEmployeeName(), employeeDTO.getEmployeeDesignation(),employeeDTO.getEmployeeSalary());
        List<Employee> newListOfEmployees = employeeDTO.getListOfEmployees();
        newListOfEmployees.add(employee);
        return newListOfEmployees;
    }

    @Override
    public Employee getEmployeeById(int id,List<Employee> employees) throws EmployeeNotFoundException {
        Employee employee=null;
        for(Employee e:employees){
            if(e.getEmployeeId()==id){
                employee=e;
                break;
            }
        }
        if(employee==null){
            throw new EmployeeNotFoundException("Employee not found with the given id , Please Retry : ");
        }
        return employee;
    }

    @Override
    public void updateEmployee(AddEmployeeDTO employeeDTO) throws EmployeeNotFoundException, NegativeSalaryException {


        List<Employee> employeeList = employeeDTO.getListOfEmployees();
        int id= employeeDTO.getEmployeeId();
        Employee employee=null;
        for(Employee emp:employeeList){
            if (emp.getEmployeeId()== id){
                emp.setEmployeeName(employeeDTO.getEmployeeName());
                emp.setEmployeeDesignation(employeeDTO.getEmployeeDesignation());
                emp.setEmployeeSalary(employeeDTO.getEmployeeSalary());
                if(emp.getEmployeeSalary()<0){
                    throw new NegativeSalaryException("Salary Cannot be in negative .");
                }
                employee=emp;
                break;
            }
        }

        if (employee!=null){
            System.out.println("Employee details updated successfully !!! \n"+employee.toString());
        }
        else{
            throw new EmployeeNotFoundException("Employee not found with the given id to update , Please Retry : ");
        }

    }

    @Override
    public List<Employee> deleteEmployeeById(int id, List<Employee> employees) throws EmployeeNotFoundException {

        Employee emp = null;
        boolean employeeFound = false;
        for (Employee employee:employees){
            if(id == employee.getEmployeeId()){
                employeeFound=true;
                emp=employee;
                break;
            }
        }
        if(employeeFound){
            employees.remove(emp);

            System.out.println("Employee with the given id deleted successfully!!!");
            return employees;
        }
        else
            throw new EmployeeNotFoundException("Employee not found with the given id to delete .");
    }
}
