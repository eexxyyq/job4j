package ru.job4j.converter;

/**
 * Конвертер валют
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class Converter {
    static final double EURO_COURSE = 70;
    static final double USD_COURSE = 60;
    /**
     * Конвертируем рубли в Евро.
     * @param value рубли
     * @return Евро
     */
    public double rubleToEuro(double value) {
        return value / EURO_COURSE;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли
     * @return Доллары
     */
    public double rubleToUSD(double value) {
        return value / USD_COURSE;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро
     * @return рубли
     */
    public double euroToRubles(double value) {
        return value * EURO_COURSE;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары
     * @return рубли
     */
    public double usdToRubles(double value) {
        return value * USD_COURSE;
    }

}
