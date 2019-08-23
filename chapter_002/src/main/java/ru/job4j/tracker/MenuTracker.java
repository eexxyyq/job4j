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
    int getActionsLength() {
        return this.actions.size();
    }

    void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new item."));
        this.actions.add(new ShowAllItems(1, "Show all of the items."));
        this.actions.add(new EditItems(2, "Edit item."));
        this.actions.add(new DeleteItem(3, "Delete item."));
        this.actions.add(new FindItemByID(4, "Find item by id."));
        this.actions.add(new FindItemByName(5, "Find item by name."));
        this.actions.add(new ExitProgram(6, "Exit program.", ui));
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
