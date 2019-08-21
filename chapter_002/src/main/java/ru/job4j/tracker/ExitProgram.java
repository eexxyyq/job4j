package ru.job4j.tracker;

public class ExitProgram implements UserAction {
    private final StartUI ui;

    public ExitProgram(StartUI ui) {
        this.ui = ui;
    }

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        this.ui.setExit();
    }

    @Override
    public String info() {
        return "6. Exit program";
    }
}
