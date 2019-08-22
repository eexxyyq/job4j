package ru.job4j.tracker;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
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
        if (exit) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
