package ki302.semon.lab5;

import java.io.*;

public class CalcIO {
    /** Запис у текстовий файл */
    public void writeText(String filename, double value) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            out.println("Result = " + value);
        }
    }

    /** Читання з текстового файлу */
    public String readText(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            return br.readLine();
        }
    }

    /** Запис у двійковий файл */
    public void writeBinary(String filename, double value) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            out.writeDouble(value);
        }
    }

    /** Читання з двійкового файлу */
    public double readBinary(String filename) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            return in.readDouble();
        }
    }
}