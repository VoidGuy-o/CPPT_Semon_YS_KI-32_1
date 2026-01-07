package ki302.semon.lab5;

public class Lab5Main {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            CalcIO io = new CalcIO();

            double x = 1.23;
            double result = calc.calculate(x);

            io.writeText("result.txt", result);
            io.writeBinary("result.bin", result);

            System.out.println("Text file says: " + io.readText("result.txt"));
            System.out.println("Binary file says: " + io.readBinary("result.bin"));
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}