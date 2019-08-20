package ru.job4j.tracker;


public class StartUI {
    public static final int ADD = 0;
    public static final int EXIT = 6;
    private final Input input;
    private Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.parseInt(input.ask("select: ")));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    private void showMenu() {
        System.out.println("      Menu\n"
                + "0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program");
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New Item with Id : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDescription());
    }

    private void showAll() {
        System.out.println("------------ Список всех заявок --------------");
        Item[] items = this.tracker.findAll();
        System.out.println("----------------------------------------------\n"
                + "name         |     description        |       id\n"
                + "-------------------------------------------------------");
        for (Item item : items) {
            System.out.println(item.getName() + "         | " + item.getDescription() + "            | " + item.getId());
        }
        System.out.println("----------------------------------------------\n\n");
    }

    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки: ");
        Item old = this.tracker.findById(id);
        if (!(old == null)) {
            String newName = this.input.ask("Введите новое имя: ");
            String newDesc = this.input.ask("Введите новое описание: ");
            Item item = new Item(newName, newDesc);
            this.tracker.replace(id, item);
            System.out.println("\n"
                    + "-----------[ Заявка с Id : " + old.getId() + " отредактирована ]----------\n"
                    + "--------------------------------------------------------------------------\n\n");
        } else {
            System.out.println("\n"
                    + "----------------------------------------------\n"
                    + "----------------[ Wrong id ]------------------\n"
                    + "----------------------------------------------\n\n");
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки: ");
        if (this.tracker.delete(id)) {
            System.out.println("\n"
                    + "-----------------[ Заявка с Id : " + id + " удалена ]---------------------\n"
                    + "--------------------------------------------------------------------------\n\n");
        } else {
            System.out.println("\n"
                    + "----------------------------------------------\n"
                    + "----------------[ Wrong id ]------------------\n"
                    + "----------------------------------------------\n\n");
        }
    }

    private void findId() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("----------------------------------------------\n"
                    + "name         |   description        |        id\n"
                    + "-------------------------------------------------------\n"
                    + item.getName() + "          | "
                    + item.getDescription() + "                  | "
                    + item.getId() + "\n"
                    + "-------------------------------------------------------------\n\n");
        } else {
            System.out.println("\n"
                    + "----------------------------------------------\n"
                    + "----------------[ Wrong id ]------------------\n"
                    + "----------------------------------------------\n\n");
        }
    }

    private void findName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] items = this.tracker.findByName(name);
        if (items != null) {
            System.out.println("----------------------------------------------\n"
                    + "name         |  description            |    id\n"
                    + "----------------------------------------------");
            for (Item item : items) {
                System.out.println(item.getName() + "          | "
                        + item.getDescription() + "                  | "
                        + item.getId());
            }
            System.out.println("----------------------------------------------\n");
        } else {
            System.out.println("\n"
                    + "------------------------------------------------\n"
                    + "----------------[ Wrong name ]------------------\n"
                    + "------------------------------------------------\n\n");
        }
    }
}