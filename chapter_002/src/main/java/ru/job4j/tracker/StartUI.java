package ru.job4j.tracker;


public class StartUI {
    public static final int ADD = 0;
    public static final int EXIT = 6;
    private final Input input;
    private Tracker tracker;

    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.parseInt(input.ask("select: ")));
        } while (!"y".equals(this.input.ask("Exit?(y/n): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
