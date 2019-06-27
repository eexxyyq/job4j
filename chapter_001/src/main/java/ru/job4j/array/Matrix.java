package ru.job4j.array;

/**
 * Рисуем таблицу умножения
 *
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class Matrix {
    /**
     * Задает размер таблицы
     * @param size размер
     * @return таблица умножения
     */
    public int[][] multiply(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
