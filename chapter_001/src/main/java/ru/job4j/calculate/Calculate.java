package ru.job4j.calculate;
/**
 *Calculate.
 *
 *@author Tikhonov Yaroslav (eexxyyq@yandex.ru)
 */
public class Calculate {
	/**
	 *Main.
	 *
	 *@param args - args.
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println(echo("bla bla bla")); }

	/**
	 *Method Echo
	 *@param name - Your name
	 *@return Echo plus your name
	 */
	public static String echo(String name) {
		return "Echo, echo, echo : " + name; }
}