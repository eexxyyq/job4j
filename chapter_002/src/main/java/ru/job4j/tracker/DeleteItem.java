package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return 3;
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

    @Override
    public String info() {
        return "3. Delete item";
    }
}
