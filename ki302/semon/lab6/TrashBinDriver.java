package ki302.semon.lab6;

public class TrashBinDriver {
    public static void main(String[] args) {
        System.out.println("=== Демонстрація бака для сміття ===\n");

        // Створимо три різні баки для різних типів
        TrashBin<Integer> intBin = new TrashBin<>();
        TrashBin<Float> floatBin = new TrashBin<>();
        TrashBin<Character> charBin = new TrashBin<>();

        // Додаємо “сміття” різних типів
        intBin.addTrash(12);
        intBin.addTrash(5);
        intBin.addTrash(99);

        floatBin.addTrash(1.5f);
        floatBin.addTrash(7.3f);
        floatBin.addTrash(2.8f);

        charBin.addTrash('Z');
        charBin.addTrash('A');
        charBin.addTrash('Q');

        // Виведемо все
        intBin.printAll();
        floatBin.printAll();
        charBin.printAll();

        // Пошук максимального/мінімального
        System.out.println("🔹 Найбільше сміття (int): " + intBin.findMax());
        System.out.println("🔹 Найменше сміття (float): " + floatBin.findMin());
        System.out.println("🔹 Найбільше сміття (char): " + charBin.findMax());
    }
}