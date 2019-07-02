package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест на поиск расстояния между точками
 */
public class PointTest {

    @Test
    public void whenZeroAndTenThenTen() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 10);
        double result = first.distance(second);
        first.info();
        second.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(10D));
        System.out.println(" ");
    }

    @Test
    public void whenCheckItself() {
        Point point = new Point(0, 0);
        double result = point.distance(point);
        point.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(0D));
        System.out.println(" ");
    }

    @Test
    public void whenShowInfo() {
        Point first = new Point(1, 1);
        first.info();
        Point second = new Point(2, 2);
        second.info();
        System.out.println(" ");
    }

    @Test
    public void whenZeroAndZeroAnd10Then10() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(0, 0, 10);
        double result = first.distance3d(second);
        first.info3d();
        second.info3d();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(10D));
        System.out.println(" ");
    }
}