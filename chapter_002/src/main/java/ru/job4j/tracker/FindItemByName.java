package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by name --------------");
        String name = input.ask("Please, provide new item's name: ");
        Item[] items = tracker.findByName(name);
        if (items != null) {
            for (Item item : items) {
                System.out.println("Id: " + item.getId() + ". \n"
                        + "Name: " + item.getName() + ". \n"
                        + "Description: " + item.getDescription() + ". \n");
                System.out.println("----------------------------------------------\n");
            }
        } else {
            System.out.println("\n"
                    + "----------------[ Wrong name ]------------------\n");
        }
    }

    @Override
    public String info() {
        return "Find item by name.";
    }
}
