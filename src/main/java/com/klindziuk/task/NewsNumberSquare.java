package com.klindziuk.task;

/*
 * Новости выводятся по 10 на страницу. Написать метод, определяющий количество страниц для вывода N новостей.
 * Написать метод, возвращающий N-значное целое случайное число.
 * Написать метод, определяющий площадь круга с радиусом X.
 * 
 * 
 */

import java.util.Random;

public class NewsNumberSquare {

	public static void main(String[] args) {

		decidePageQuantity(0);
		decidePageQuantity(-1);
		decidePageQuantity(100);
		decidePageQuantity(32);
		System.out.println(getRandomNumber(3));
		circleSquare(2);

	}

	public static int getRandomNumber(int numberOFDigits) {

		Random generator = new Random();

		return generator.nextInt((int) Math.pow(10, numberOFDigits));
	}

	public static void circleSquare(double radius) {

		try {
			if (radius <= 0) {
				throw new IllegalArgumentException();
			}

			System.out.println(Math.PI * Math.pow(radius, 2));
		}

		catch (IllegalArgumentException iaex) {
			System.out.println("Radius should be greater than zero.");
		}

	}

	public static void decidePageQuantity(int numberOfNews) {

		try {
			if (numberOfNews <= 0) {
				throw new IllegalArgumentException();
			}

			if (numberOfNews % 10 > 0) {
				System.out.println("You need " + ((numberOfNews / 10) + 1) + " page(s) ");

			}

			else {

				System.out.println("You need " + (numberOfNews / 10) + " page(s) ");
			}

		} catch (IllegalArgumentException iaex) {
			System.out.println("Quantity of news should be greater than zero.");
		}

	}
}
