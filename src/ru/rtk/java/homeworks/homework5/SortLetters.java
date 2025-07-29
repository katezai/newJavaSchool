package ru.rtk.java.homeworks.homework5;

import java.util.Arrays;
import java.util.Scanner;

public class SortLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два слова на латинице через пробел: ");
        String input = scanner.nextLine(); // Чтение всей строки

        String lowerLine = input.toLowerCase();
        String[] words = lowerLine.split(" ");

        if (words.length!=2) {
            System.out.println ("Ошибка! Требуется ввести ровно два слова");
            scanner.close();
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            result.append(sortedWord);

            if (i< words.length-1) {
                result.append(" ");
            }
        }
        System.out.println("Результат: "+result.toString());
        scanner.close();
    }
}
