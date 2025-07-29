package ru.rtk.java.homeworks.homework5;

import java.util.Scanner;

public class ArrowCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку из символов: '>', '<' и '-'");
        String s = scanner.next();
        //System.out.println("введенная строка: "+s);
        int n = s.length();
        //System.out.println("Длина строки: "+ n);
        int count = 0;

        for (int i = 0; i <= n - 5; i++) {
            String substring = s.substring(i, i + 5);
            if (substring.equals(">>-->") || substring.equals("<--<<")) {
                count++;
                //System.out.println("найдена стрелка! Текущий счет: "+ count);
            }
        }

        System.out.println("Всего стрелок: "+ count);
        scanner.close();
    }
}
