package ru.job4j.array;

import java.util.Arrays;

/**
 * Переворот массива
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class Turn {
    /**
     * Переворот через temp
     * @param array массив
     * @return обратный массив
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
