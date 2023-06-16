package Exceptions;

public class NegativeSalaryException extends Exception{

    public NegativeSalaryException(String s){
        super(s);
        System.out.println(s);
    }
}
