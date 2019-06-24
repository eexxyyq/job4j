package ru.job4j.condition;

import java.lang.Math;

/**
 * Вычисления параметров прямоугольника
 * @author Tikhonov Yaroslav
 */
public class SqArea {
    /**
     * Вычисление площади
     * @param p периметр
     * @param k коэффициент w = h * k
     * @return площадь
     */
    public int square(int p, int k) {
        int h = (int) Math.sqrt(p / (2 * k));
        int w = h * k;
        return h * w;

    }
}
