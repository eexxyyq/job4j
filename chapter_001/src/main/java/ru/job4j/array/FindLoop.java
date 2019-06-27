package ru.job4j.array;

/**
 * Поиск перебором
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
