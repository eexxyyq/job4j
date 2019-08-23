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

    @Override
    public String info() {
        return "5. Find item by name.";
    }
}
