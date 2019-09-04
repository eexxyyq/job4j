package ru.job4j.tracker;

import java.util.List;

public class FindItemByName extends BaseAction {
    FindItemByName(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by name --------------");
        String name = input.ask("Please, provide new item's name: ");
        List<Item> items = tracker.findByName(name);
        if (items != null) {
            for (Item item : items) {
                System.out.println("Id: " + item.getId() + ". " + System.lineSeparator()
                        + "Name: " + item.getName() + ". " + System.lineSeparator()
                        + "Description: " + item.getDescription() + ". " + System.lineSeparator());
                System.out.println("----------------------------------------------" + System.lineSeparator());
            }
        } else {
            System.out.println(System.lineSeparator()
                                + "----------------[ Wrong name ]------------------"
                                + System.lineSeparator());
        }
    }
}
