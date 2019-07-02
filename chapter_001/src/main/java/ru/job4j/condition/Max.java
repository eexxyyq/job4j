package ru.job4j.condition;

/**
 * Максимум из двух/трех/четырех чисел
 * @author Tikhonov Yaroslav
 */
class Max {
    int max(int first, int second) {
        return first >= second ? first : second;
    }

    int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    int max(int first, int second, int third, int fourth) {
        return max(first, max(second, max(third, fourth)));
    }
}
