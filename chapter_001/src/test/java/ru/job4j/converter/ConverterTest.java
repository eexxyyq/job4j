package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для конвертера валют.
 *
 * @author Tikhonov Yaroslav (eexxyyq@yandex.ru);
 */
public class ConverterTest {
    /**
     * Тест конвертера из рубли в доллары
     */
    @Test
    public void when60RublesToUSDThenOne() {
        Converter conv = new Converter();
        double result = conv.rubleToUSD(60);
        double expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Тест конвертера из рубли в евро
     */
    @Test
    public void when70RublesToEuroThenOne() {
        Converter conv = new Converter();
        double result = conv.rubleToEuro(70);
        double expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Тест конвертера из евро в рубли
     */
    @Test
    public void whenOneEuroToRublesThen70() {
        Converter conv = new Converter();
        double result = conv.euroToRubles(1);
        double expected = 70;
        assertThat(result, is(expected));
    }

    /**
     * Тест конвертера из долларов в рубли
     */
    @Test
    public void whenOneUSDToRublesThen60() {
        Converter conv = new Converter();
        double result = conv.usdToRubles(1);
        double expected = 60;
        assertThat(result, is(expected));
    }

}
