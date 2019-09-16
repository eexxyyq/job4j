package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    private final StringBuilder menu = new StringBuilder()
            .append("0. Add new item.")
            .append(System.lineSeparator())
            .append("1. Show all of the items.")
            .append(System.lineSeparator())
            .append("2. Edit item.")
            .append(System.lineSeparator())
            .append("3. Delete item.")
            .append(System.lineSeparator())
            .append("4. Find item by id.")
            .append(System.lineSeparator())
            .append("5. Find item by name.")
            .append(System.lineSeparator())
            .append("6. Exit program.");

    @Test
    public void whenUserWantToSeeAllOfTheItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(this.output.toString(), is(
                new StringBuilder()
                .append(menu.toString())
                .append(System.lineSeparator())
                .append("------------ List of the Items --------------")
                .append(System.lineSeparator())
                .append("Item 1. ")
                .append(System.lineSeparator())
                .append("Id: ")
                .append(item1.getId())
                .append(". ")
                .append(System.lineSeparator())
                .append("Name: ")
                .append(item1.getName())
                .append(". ")
                .append(System.lineSeparator())
                .append("Description: ")
                .append(item1.getDescription())
                .append(". ")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenUserWantToFindIemById() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"4", item1.getId(), "y"});
        new StartUI(input, tracker, output).init();
        assertThat(this.output.toString(), is(
                new StringBuilder()
                        .append(menu.toString())
                        .append(System.lineSeparator())
                        .append("------------ Find Item by Id --------------")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(item1.getId())
                        .append(". ")
                        .append(System.lineSeparator())
                        .append("Name: ")
                        .append(item1.getName())
                        .append(". ")
                        .append(System.lineSeparator())
                        .append("Description: ")
                        .append(item1.getDescription())
                        .append(". ")
                        .append(System.lineSeparator())
                        .append(System.lineSeparator())
                        .toString()
        ));
    }
    @Test
    public void whenUserWantToFindIemByIName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1", "desc1"));
        Input input = new StubInput(new String[]{"5", item1.getName(), "y"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(menu.toString())
                        .append(System.lineSeparator())
                        .append("------------ Find item by name --------------")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(item1.getId())
                        .append(". ")
                        .append(System.lineSeparator())
                        .append("Name: ")
                        .append(item1.getName())
                        .append(". ")
                        .append(System.lineSeparator())
                        .append("Description: ")
                        .append(item1.getDescription())
                        .append(". ")
                        .append(System.lineSeparator())
                        .append("----------------------------------------------")
                        .append(System.lineSeparator())
                        .append(System.lineSeparator())
                        .toString()
        ));
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test name", "desc"));
        Input input = new StubInput(new String[] {"3", item.getId(), "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }


}
