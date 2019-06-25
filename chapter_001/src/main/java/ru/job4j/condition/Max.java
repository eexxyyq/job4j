package ru.job4j.condition;

/**
 * Максимум из двух чисел
 * @author Tikhonov Yaroslav
 */
public class Max {
    public int max(int first, int second) {
        return first >= second ? first : second;
    }
}
