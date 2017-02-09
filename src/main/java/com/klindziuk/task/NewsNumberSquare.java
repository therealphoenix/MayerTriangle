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
	public static final int QUANTITYNEWSONPAGE = 10;

	public static void main(String[] args) {

	
	}

	public static int getRandomNumber(int numberOfDigits) {
		
		
		if(numberOfDigits <= 0){
			
			throw new UnsupportedOperationException();
				
		}
			Random generator = new Random();

		return generator.nextInt((int) Math.pow(10, numberOfDigits));
		
			}

	public static double circleSquare(double radius) {
		
         double result = 0;
		
			if (radius <= 0) {
				throw new IllegalArgumentException();
			}

			result = (Math.PI * Math.pow(radius, 2));
			
		return result;

	}

	public static void getPageQuantity(int numberOfNews) {

		try {
			if (numberOfNews <= 0) {
				throw new IllegalArgumentException();
			}

			if (numberOfNews % 10 > 0) {
				System.out.println("You need " + ((numberOfNews / QUANTITYNEWSONPAGE ) + 1) + " page(s) ");

			}

			else {

				System.out.println("You need " + (numberOfNews / QUANTITYNEWSONPAGE) + " page(s) ");
			}

		} catch (IllegalArgumentException iaex) {
			System.out.println("Quantity of news should be greater than zero.");
		}

	}
}
