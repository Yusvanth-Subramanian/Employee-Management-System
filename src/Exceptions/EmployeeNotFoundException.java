package Exceptions;

public class EmployeeNotFoundException extends Exception{

    public EmployeeNotFoundException(String s){
        super(s);
        System.out.println(s);
    }

}
