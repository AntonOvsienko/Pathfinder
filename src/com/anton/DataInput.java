package com.anton;

import com.anton.ClassPlayer.Warior;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class DataInput {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer InputInteger() {
        while (true) {
            try {
                String xtemp = scanner.nextLine();
                int x = Integer.parseInt(xtemp);
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
                continue;
            }
        }
    }
}
