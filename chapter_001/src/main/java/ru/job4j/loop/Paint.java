package ru.job4j.loop;

/**
 * Рисуем пирамиду с помощью StringBuilder'a
 *
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class Paint {
    /**
     * Рисуем правую сторону пирамиды
     *
     * @param height высота пирамиды
     * @return рисунок стороны
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Рисуем левую сторону пирамиды
     *
     * @param height высота пирамиды
     * @return рисунок стороны
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (row >= width - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * Рисуем пирамиду
     *
     * @param height высота пирамиды
     * @return рисунок пирамиды
     */
    public String trl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
