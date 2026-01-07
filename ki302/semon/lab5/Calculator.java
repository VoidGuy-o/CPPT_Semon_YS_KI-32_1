package ki302.semon.lab5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Calculator {
    protected PrintWriter fout;

    public Calculator() throws FileNotFoundException{
        this.fout = new PrintWriter(new File("CalcLog.txt"));
        log("Calculator created.");
    }

    private void log(String msg) {
        if (fout != null) {
            fout.println(msg);
            fout.flush();
        }
    }

    public double calculate(double x) {
        double sin2x = Math.sin(2 * x);
        if (sin2x == 0) {
            log("Calculation UNsuccessful for x = " + x);
            throw new ArithmeticException("Division by zero: sin(2x) = 0");
        }
    
        double ctg = Math.cos(2 * x) / sin2x;
        double result = Math.sin((3 * x) - 5) / ctg;
    
        // Якщо результат 0 — вважаємо це помилковим значенням (умова штучна, для демонстрації)
        if (result == 0) {
            log("Calculation UNsuccessful for x = " + x);
            throw new ArithmeticException("Computation result is zero — invalid value for this function");
        }
    
        // Якщо результат нескінченний або NaN
        if (Double.isInfinite(result) || Double.isNaN(result)) {
            log("Calculation UNsuccessful for x = " + x + "\n HALT");
            throw new ArithmeticException("Invalid mathematical result (∞ or NaN)");
        }
    
        log("Calculation successful for x = " + x);
        return result;
    }
}
