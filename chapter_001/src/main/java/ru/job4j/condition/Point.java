package ru.job4j.condition;

import java.lang.Math;

/**
 * Вычисляем расстояние между точками.
 * @author Tikhonov Yaroslav
 */
public class Point {
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
