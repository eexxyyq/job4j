package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Delete item --------------");
        String id = input.ask("Please, provide item's id: ");
        if (tracker.delete(id)) {
            System.out.println(System.lineSeparator()
                    + "-----------------[ Item with Id : " + id + " has been deleted ]----------------" + System.lineSeparator());
        }  else {
            System.out.println(System.lineSeparator()
                    + " ----------------[ Wrong id ]------------------ "
            + System.lineSeparator());
        }
    }
}
