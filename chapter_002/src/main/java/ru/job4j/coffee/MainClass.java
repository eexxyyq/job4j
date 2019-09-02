package ru.job4j.coffee;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select price");
        int price = scanner.nextInt();
        System.out.println("Make money");
        int value = scanner.nextInt();
        Giving g = new Giving(value, price);
        g.changes();
    }
}