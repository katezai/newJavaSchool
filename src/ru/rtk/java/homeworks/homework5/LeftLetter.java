package ru.rtk.java.homeworks.homework5;

import java.util.Scanner;

public class LeftLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строчную букву литинского алфавита: " );
        char inputChar = scanner.next().charAt(0);
        System.out.println(getLeftChar(inputChar));

    }

    public static char getLeftChar(char c) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        if (c == 'a') return 'p';
        if (c == 'z') return 'l';
        if (c == 'q') return 'm';

        // Проверяем, в какой строке находится символ
        if (row1.indexOf(c) != -1) {
            int index = (row1.indexOf(c) - 1 + row1.length()) % row1.length();
            return row1.charAt(index);
        }
        else if (row2.indexOf(c) != -1) {
            int index = (row2.indexOf(c) - 1 + row2.length()) % row2.length();
            return row2.charAt(index);
        }
        else if (row3.indexOf(c) != -1) {
            int index = (row3.indexOf(c) - 1 + row3.length()) % row3.length();
            return row3.charAt(index);
        }
        else {
            return c;
        }
    }
}


