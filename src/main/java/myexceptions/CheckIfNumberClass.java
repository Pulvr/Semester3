package myexceptions;

import java.text.ParseException;

public class CheckIfNumberClass {
    public static void main(String[] args) {
        System.out.println(toDouble("123a"));
    }

    static double toDouble(String number) throws IsNotANumberException{
        try{
            return Double.parseDouble(number);
        }catch (NumberFormatException e){
            throw new IsNotANumberException("Keine Zahl");
        }
    }
}
