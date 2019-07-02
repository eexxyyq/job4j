package ru.job4j.condition;

/**
 * Максимум из двух чисел
 * @author Tikhonov Yaroslav
 */
public class Max {
    public int max(int first, int second) {
        return first >= second ? first : second;
    }

    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public int max(int first, int second, int third, int fourth) {
        return max(first, max( second, max(third, fourth)));
    }
}
