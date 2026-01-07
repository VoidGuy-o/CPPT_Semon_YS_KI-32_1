package ki302.semon.lab4;

import java.io.FileNotFoundException;

public class Lab4Main {
    public static void main(String[] args){
        try {
        
            java.util.Scanner scan = new java.util.Scanner(System.in);
            Calculator calc = new Calculator();
            System.out.println("Enter your number:");
            String assad = scan.nextLine();
            double xx = Double.parseDouble(assad);
            System.out.println("Result is "+ calc.calculate(xx));
        }
        
        catch (FileNotFoundException e) {
            System.err.println("File not Found");
        }
        catch (ArithmeticException err) {
            System.err.println("Your number is wrong");
        }
        catch (NumberFormatException err){
            System.err.println("Are you sure you wrote a number?");
        }
    }
}
