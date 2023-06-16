package Exceptions;

public class EmployeeAlreadyExistsException extends Exception{

    public EmployeeAlreadyExistsException(String s){
        super(s);
        System.out.println(s);
    }

}
