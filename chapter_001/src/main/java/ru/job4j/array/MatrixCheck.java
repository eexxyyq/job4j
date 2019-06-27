package ru.job4j.array;

/**
 * Проверка однородности диагоналей
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                result = false;
            } else if (data[data.length - 1 - i][i] != data[data.length - 2 - i][i + 1]) {
                result = false;
            }
        }
        return result;
    }
}
