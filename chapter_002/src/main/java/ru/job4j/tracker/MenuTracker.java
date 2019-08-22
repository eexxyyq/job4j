package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private final StartUI uui;

    MenuTracker(Input input, Tracker tracker, StartUI uui) {
        this.input = input;
        this.tracker = tracker;
        this.uui = uui;
    }
    public int getActionsLength() {
        return this.actions.size();
    }

    void fillActions(StartUI ui) {
        this.actions.add(new AddItem());
        this.actions.add(new ShowAllItems());
        this.actions.add(new EditItems());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemByID());
        this.actions.add(new FindItemByName());
        this.actions.add(new ExitProgram(ui));
    }

    void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    void stop(String key) {
        if (key.equals("y")) {
            this.uui.setExit();
        }
    }
    void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
