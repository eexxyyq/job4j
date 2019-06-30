package ru.job4j.array;

/**
 * Слияние двух упорядоченных массивов
 *
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class FinalArray {
    /**
     * Метод принимает два отсортированных массива и делает их слияние в третий.
     * @param first массив
     * @param second массив
     * @return отсортированный массив
     */
    public int[] sortedArray(int[] first, int[] second) {
        int[] sorted = new int[first.length + second.length];
        int elSorted = 0;
        int elFirst = 0;
        int elSecond = 0;
        while (elSorted < sorted.length - 1) {
            if (first[elFirst] <= second[elSecond]) {
                sorted[elSorted] = first[elFirst];
                if (elFirst < first.length - 1) {
                    elFirst++;
                }
                elSorted++;
            } else {
                sorted[elSorted] = second[elSecond];
                if (elSecond < second.length - 1) {
                    elSecond++;
                }
                elSorted++;
            }
        }
        sorted[sorted.length - 1] = first[first.length - 1] > second[second.length - 1] ? first[first.length - 1] : second[second.length - 1];
        return sorted;
    }
}
