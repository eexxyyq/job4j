package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*CalculateTest.
*
*@author Tikhonov Yaroslav (eexxyyq@yandex.ru)
*/
public class CalculateTest {
	/**
	*Test Echo.
	*/

	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Tikhonov Yaroslav";
		String except = "Echo, echo, echo : Tikhonov Yaroslav";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(except));
	}
	
}