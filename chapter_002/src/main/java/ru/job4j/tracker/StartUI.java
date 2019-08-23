package ru.job4j.tracker;

public class StartUI {
    private final Input input;
    private Tracker tracker;
    private boolean isExit = false;
    void setExit() {
        this.isExit = true;
    }

    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this);
        menu.fillActions(this);
        int rangeLength = menu.getActionsLength();
        int[] ranges = new int[rangeLength];
        for (int i = 0; i < rangeLength; i++) {
            ranges[i] = i;
        }
        do {
            menu.show();
            int s = input.ask("select: ", ranges);
            if (s != 6) {
                menu.select(s);
            } else {
                setExit();
                break;
            }
            menu.stop(input.ask("exit? (y) "));
        } while (!isExit);
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
