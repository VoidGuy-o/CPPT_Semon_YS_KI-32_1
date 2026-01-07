import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ЛР №1 (Варіант 1).
 * Генерація зубчатого масиву, який містить лише заштриховану область
 * квадратної матриці N×N (верхній правий трикутник над головною діагоналлю, включно з нею).
 *
 * <p>Ввід: N та символ-заповнювач (рівно 1 символ).
 * <br>Вивід: сформований зубчатий масив у консоль та у файл MyFile.txt.
 */
public class Lab1SemonKI302 { // <-- перейменуй під себе (і файл так само)

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть розмір квадратної матриці N: ");
        int n;
        try {
            n = in.nextInt();
        } catch (Exception ex) {
            System.out.println("Некоректне N. Завершення.");
            return;
        }
        in.nextLine(); // з’їсти '\n'

        if (n <= 0) {
            System.out.println("N має бути > 0. Завершення.");
            return;
        }

        System.out.print("Введіть символ-заповнювач (1 символ): ");
        String filler = in.nextLine();

        if (filler.length() == 0) {
            System.out.println("Не введено символ-заповнювач. Завершення.");
            return;
        }
        if (filler.length() != 1) {
            System.out.println("Забагато символів-заповнювачів. Завершення.");
            return;
        }

        char ch = filler.charAt(0);

        // Варіант 1: заштриховано клітини (i, j), де j >= i (верхній правий трикутник, включно з діагоналлю)
        char[][] arr = buildVariant1Jagged(n, ch);

        File outFile = new File("MyFile.txt");
        try (PrintWriter fout = new PrintWriter(outFile)) {
            printJagged(arr, fout);   // у файл
            printJagged(arr, null);   // у консоль
            System.out.println("\nЗбережено у файл: " + outFile.getName());
        } catch (FileNotFoundException e) {
            System.out.println("Не вдалося створити файл для запису. Завершення.");
        }
    }

    /**
     * Створює зубчатий масив для варіанту 1.
     * У рядку i зберігаються лише заштриховані елементи (j >= i), тобто довжина рядка = N - i.
     *
     * @param n розмір матриці N×N
     * @param fill символ-заповнювач
     * @return зубчатий масив заштрихованої області
     */
    private static char[][] buildVariant1Jagged(int n, char fill) {
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            int len = n - i;          // j = i..n-1
            arr[i] = new char[len];
            for (int k = 0; k < len; k++) {
                arr[i][k] = fill;
            }
        }
        return arr;
    }

    /**
     * Друк зубчатого масиву.
     *
     * @param arr зубчатий масив
     * @param out якщо out == null, друкує в консоль; інакше — в переданий PrintWriter
     */
    private static void printJagged(char[][] arr, PrintWriter out) {
        for (int i = 0; i < arr.length; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < arr[i].length; j++) {
                line.append(arr[i][j]).append(' ');
            }

            if (out == null) {
                System.out.println(line.toString());
            } else {
                out.println(line.toString());
            }
        }
    }
}