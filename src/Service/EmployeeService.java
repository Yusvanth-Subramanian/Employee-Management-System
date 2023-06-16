package Service;

import DTO.AddEmployeeDTO;
import Entity.Employee;
import Exceptions.EmployeeAlreadyExistsException;
import Exceptions.EmployeeNotFoundException;
import Exceptions.NegativeSalaryException;

import java.util.List;

public interface EmployeeService {

    public List<Employee> addEmployee(AddEmployeeDTO employeeDTO) throws EmployeeAlreadyExistsException, NegativeSalaryException;

    public Employee getEmployeeById(int id,List<Employee> employees) throws EmployeeNotFoundException;

    public void updateEmployee(AddEmployeeDTO employeeDTO) throws EmployeeNotFoundException, NegativeSalaryException;

    public List<Employee> deleteEmployeeById(int id, List<Employee> employees) throws EmployeeNotFoundException;

}
