package ru.job4j.tracker;

public class ShowAllItems implements UserAction {
    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        int count = 1;
        System.out.println("------------ List of the Items --------------");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println("Item " + count + ". " + System.lineSeparator()
                    + "Id: " + item.getId() + ". " + System.lineSeparator()
                    + "Name: " + item.getName() + ". " + System.lineSeparator()
                    + "Description: " + item.getDescription() + ". " + System.lineSeparator());
            count++;
        }
    }

    @Override
    public String info() {
        return "1. Show all of the Items.";
    }
}
