package ru.job4j.array;

/**
 * Проверка массива на однородность элементов
 */
public class Check {
    /**
     * Решение через временную переменную для сравнения с остальными
     * @param array массив
     * @return true/false
     */
    public boolean check(boolean[] array) {
        boolean chk = false;
        boolean tmp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != tmp) {
                chk = false;
                break;
            } else {
                chk = true;
            }
        }
        return chk;
    }
    /**
     * Решение через сравнение соседних элементов
     * @param array массив
     * @return true/false
     */
    public boolean mono(boolean[] array) {
        boolean result = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
