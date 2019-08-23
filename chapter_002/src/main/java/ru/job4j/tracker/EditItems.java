package ru.job4j.tracker;

public class EditItems implements UserAction {
    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Edit item --------------");
        String id = input.ask("Please, provide item's id: ");
        Item old = tracker.findById(id);
        if (!(old == null)) {
            String newName = input.ask("Please, provide new item's name: ");
            String newDesc = input.ask("Please, provide new item's description: ");
            Item item = new Item(newName, newDesc);
            tracker.replace(id, item);
            System.out.println(System.lineSeparator()
                                + "-----------[ Item with Id : " + old.getId() + " has been changed ]--------"
                                + System.lineSeparator());
        } else {
            System.out.println(System.lineSeparator()
                                + " ----------------[ Wrong id ]------------------ "
                                + System.lineSeparator());
        }
    }

    @Override
    public String info() {
        return "2. Edit item.";
    }
}
