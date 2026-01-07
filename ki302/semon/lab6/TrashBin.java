package ki302.semon.lab6;

import java.util.*;

/**
 * Параметризований клас TrashBin — "Бак для сміття".
 * Приймає будь-який тип, який реалізує Comparable.
 */
public class TrashBin<T extends Comparable<T>> {
    private ArrayList<T> trashList;

    public TrashBin() {
        trashList = new ArrayList<>();
    }

    /** Додає новий елемент у бак */
    public void addTrash(T item) {
        trashList.add(item);
        System.out.println("🗑️ Додано сміття: " + item);
    }

    /** Видаляє елемент за індексом */
    public void removeTrash(int index) {
        if (index >= 0 && index < trashList.size()) {
            System.out.println("🚮 Видалено: " + trashList.remove(index));
        } else {
            System.out.println("⚠️ Невірний індекс!");
        }
    }

    /** Виводить усе сміття */
    public void printAll() {
        System.out.println("\n--- Вміст бака ---");
        for (T item : trashList)
            System.out.println(" • " + item);
        System.out.println("------------------\n");
    }

    /** Повертає найбільший елемент */
    public T findMax() {
        if (trashList.isEmpty()) return null;
        T max = trashList.get(0);
        for (T item : trashList)
            if (item.compareTo(max) > 0)
                max = item;
        return max;
    }

    /** Повертає найменший елемент */
    public T findMin() {
        if (trashList.isEmpty()) return null;
        T min = trashList.get(0);
        for (T item : trashList)
            if (item.compareTo(min) < 0)
                min = item;
        return min;
    }
}