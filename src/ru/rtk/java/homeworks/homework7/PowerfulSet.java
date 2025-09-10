package ru.rtk.java.homeworks.homework7;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {

    /**
      public <T> Set<T> intersection – возвращает
      пересечение двух наборов.
      Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {1, 2}
     */
    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    /**
     public <T> Set<T> union(Set<T> set1, Set<T> set2) – возвращает
     объединение двух наборов
     Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {0, 1, 2, 3, 4}
     */
    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    /**
     public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) –
     возвращает элементы первого набора без тех, которые находятся также и
     во втором наборе.
     Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {3}
     */
    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }
    //Проверка (пример):
    public static void main(String[] args) {
        PowerfulSet powerfulSet = new PowerfulSet();

        // Тестовые данные
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(0, 1, 2, 4);

        // Тестирование методов
        System.out.println("Пересечение: " + powerfulSet.intersection(set1, set2));
        System.out.println("Объединение: " + powerfulSet.union(set1, set2));
        System.out.println("Относительное дополнение: " + powerfulSet.relativeComplement(set1, set2));
    }
}
