package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    public Consumer<String> output;
    private final StartUI uui;

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output, StartUI uui) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
        this.uui = uui;
    }

    int getActionsLength() {
        return this.actions.size();
    }

    void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new item."));
        this.actions.add(new ShowAllItems(1, "Show all of the items."));
        this.actions.add(new EditItems(2, "Edit item."));
        this.actions.add(new DeleteItem(3, "Delete item."));
        this.actions.add(new FindItemByID(4, "Find item by id."));
        this.actions.add(new FindItemByName(5, "Find item by name."));
        this.actions.add(new ExitProgram(6, "Exit program.", ui));
    }

    void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    void stop(String key) {
        if (key.equals("y")) {
            this.uui.setExit();
        }
    }
    void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

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
                output.accept("Item " + count + ". " + System.lineSeparator()
                        + "Id: " + item.getId() + ". " + System.lineSeparator()
                        + "Name: " + item.getName() + ". " + System.lineSeparator()
                        + "Description: " + item.getDescription() + ". " + System.lineSeparator());
                count++;
            }
        }
    }

    public class AddItem extends BaseAction {
        AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ New Item with Id : " + item.getId()
                    + "------------ New Item with Name : " + item.getName()
                    + "------------ New Item with Description : " + item.getDescription());
        }
    }

    public class DeleteItem extends BaseAction {
        DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete item --------------");
            String id = input.ask("Please, provide item's id: ");
            if (tracker.delete(id)) {
                output.accept(System.lineSeparator()
                        + "-----------------[ Item with Id : "
                        + id + " has been deleted ]----------------"
                        + System.lineSeparator());
            }  else {
                output.accept(System.lineSeparator()
                        + " ----------------[ Wrong id ]------------------ "
                        + System.lineSeparator());
            }
        }
    }
    public class EditItems extends BaseAction {
        EditItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Edit item --------------");
            String id = input.ask("Please, provide item's id: ");
            Item old = tracker.findById(id);
            if (!(old == null)) {
                String newName = input.ask("Please, provide new item's name: ");
                String newDesc = input.ask("Please, provide new item's description: ");
                Item item = new Item(newName, newDesc);
                tracker.replace(id, item);
                output.accept(System.lineSeparator()
                        + "-----------[ Item with Id : " + old.getId() + " has been changed ]--------"
                        + System.lineSeparator());
            } else {
                output.accept(System.lineSeparator()
                        + " ----------------[ Wrong id ]------------------ "
                        + System.lineSeparator());
            }
        }
    }
    public class FindItemByID extends BaseAction {
        FindItemByID(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Find Item by Id --------------");
            String id = input.ask("Please, provide item's id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept("Id: " + item.getId() + ". " + System.lineSeparator()
                        + "Name: " + item.getName() + ". " + System.lineSeparator()
                        + "Description: " + item.getDescription() + ". " + System.lineSeparator());
            } else {
                output.accept(System.lineSeparator()
                        + "----------------[ Wrong id ]------------------"
                        + System.lineSeparator());
            }
        }
    }
    public class FindItemByName extends BaseAction {
        FindItemByName(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Find item by name --------------");
            String name = input.ask("Please, provide new item's name: ");
            List<Item> items = tracker.findByName(name);
            if (items != null) {
                for (Item item : items) {
                    output.accept("Id: " + item.getId() + ". " + System.lineSeparator()
                            + "Name: " + item.getName() + ". " + System.lineSeparator()
                            + "Description: " + item.getDescription() + ". " + System.lineSeparator()
                            + "----------------------------------------------" + System.lineSeparator());
                }
            } else {
                output.accept(System.lineSeparator()
                        + "----------------[ Wrong name ]------------------"
                        + System.lineSeparator());
            }
        }
    }
    public static class ExitProgram extends BaseAction {
        private final StartUI ui;

        ExitProgram(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.setExit();
        }

    }
}
