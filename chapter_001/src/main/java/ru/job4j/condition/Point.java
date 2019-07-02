package ru.job4j.condition;

import java.lang.Math;

/**
 * Вычисляем расстояние между точками.
 * @author Tikhonov Yaroslav
 */
class Point {
    private int x;
    private int y;
    private int z;

    Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }

    double distance(Point that) {
        return Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2));
    }

    double distance3d(Point that) {
        return Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2) + Math.pow((this.z - that.z), 2));
    }
    void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
    void info3d() {
        System.out.println(String.format("Point[%s, %s, %s]", this.x, this.y, this.z));
    }
}
