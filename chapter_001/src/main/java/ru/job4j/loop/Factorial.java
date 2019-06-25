package ru.job4j.loop;

/**
 * Вычисление факториала числа n
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class Factorial {
    /**
     * Метод вычисляет факториал числа n с учетом того, что факториал положительного числа не может быть меньше единицы
     * @param n число, факториал которого нужно вычислить
     * @return факториал числа n
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
