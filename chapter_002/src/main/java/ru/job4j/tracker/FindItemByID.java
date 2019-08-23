package ru.job4j.tracker;

public class FindItemByID implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find Item by Id --------------");
        String id = input.ask("Please, provide item's id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Id: " + item.getId() + ". " + System.lineSeparator()
                    + "Name: " + item.getName() + ". " + System.lineSeparator()
                    + "Description: " + item.getDescription() + ". " + System.lineSeparator());
        } else {
            System.out.println(System.lineSeparator()
                                + "----------------[ Wrong id ]------------------"
                                + System.lineSeparator());
        }
    }

    @Override
    public String info() {
        return "4. Find Item by Id";
    }
}
