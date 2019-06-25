package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int tmp;
        if (first > second) {
            if (first > third) {
                tmp = first;
            } else {
                tmp = third;
            }
        } else {
            if (second > third) {
                tmp = second;
            } else {
                tmp = third;
            }
        }
        return tmp;
    }
}
