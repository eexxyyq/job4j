package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) {
        int key = Integer.parseInt(this.ask(question));
        boolean exit = false;
        for (int value : range) {
            if (value  == key) {
                exit = true;
                break;
            }
        }
        if (!exit) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}
