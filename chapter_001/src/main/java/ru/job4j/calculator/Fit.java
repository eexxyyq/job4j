package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 *
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class Fit {
    public static final double CONST = 1.15;
    public static final double MEN_DIF = 100;
    public static final double WOMAN_DIF = 110;

    /**
     * Расчет идельного веса для мужчин
     * @param height см
     * @return вес, кг
     */
    public double manWeight(double height) {
        return (height - MEN_DIF) * CONST;
    }

    /**
     * Расчет идельного веса для женщин
     * @param height см
     * @return Вес, кг
     */
    public double womanWeight(double height) {
        return (height - WOMAN_DIF) * CONST;
    }
}
