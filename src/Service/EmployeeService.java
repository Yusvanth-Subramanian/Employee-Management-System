package Service;

import DTO.AddEmployeeDTO;
import Entity.Employee;
import Exceptions.EmployeeAlreadyExistsException;
import Exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    public List<Employee> addEmployee(AddEmployeeDTO employeeDTO) throws EmployeeAlreadyExistsException;

    public Employee getEmployeeById(int id,List<Employee> employees) throws EmployeeNotFoundException;

    public void updateEmployee(AddEmployeeDTO employeeDTO) throws EmployeeNotFoundException;

    public List<Employee> deleteEmployeeById(int id, List<Employee> employees) throws EmployeeNotFoundException;

}
