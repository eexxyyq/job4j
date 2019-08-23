package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;

    ValidateInput(Input input) {
        this.input = input;
    }
    public String ask (String question) {
        return this.input.ask(question);
    }
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please, select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please, enter a validate data. ");
            }
        } while (invalid);
        return value;
    }
}
