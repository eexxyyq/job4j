package ru.job4j.array;

import java.util.Arrays;

/**
 * поиск повторений в массиве
 *
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int count = 0;
        String temp;
        for (int i = 0; i < array.length - count; i++) {
            for (int j = i + 1; j < array.length - count; j++) {
                if (array[i].equals(array[j])) {
                    temp = array[j];
                    array[j] = array[array.length - count - 1];
                    array[array.length - count - 1] = temp;
                    count++;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, array.length - count);
    }
}
