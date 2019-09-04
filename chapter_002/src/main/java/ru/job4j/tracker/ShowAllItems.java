package ru.job4j.tracker;

import java.util.List;

public class ShowAllItems extends BaseAction {
    ShowAllItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        int count = 1;
        System.out.println("------------ List of the Items --------------");
        List<Item> items = tracker.findAll();
        for (Item item : items) {
            System.out.println("Item " + count + ". " + System.lineSeparator()
                    + "Id: " + item.getId() + ". " + System.lineSeparator()
                    + "Name: " + item.getName() + ". " + System.lineSeparator()
                    + "Description: " + item.getDescription() + ". " + System.lineSeparator());
            count++;
        }
    }
}
