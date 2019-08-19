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
            System.out.println("\n"
                    + "-----------------[ Item with Id : " + id + " has been deleted ]----------------\n");
        }  else {
            System.out.println("\n ----------------[ Wrong id ]------------------ \n");
        }
    }

    @Override
    public String info() {
        return "Delete item";
    }
}
