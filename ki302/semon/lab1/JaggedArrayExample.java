public class JaggedArrayExample {
    public static void main(String[] args) {
        // створимо зубчастий масив з 3 рядків
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1, 2, 3};
        jagged[1] = new int[]{4, 5};
        jagged[2] = new int[]{6, 7, 8, 9};

        // виведемо його на екран
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}