package com.klindziuk.task;

/* 
 *  Новости выводятся по 10 на страницу. Написать метод, определяющий количество страниц для вывода N новостей.
 */

public class News {
	
	public static final int QUANTITY_NEWS_ON_PAGE = 10;

		
	public void getPageQuantity(int numberOfNews) throws IllegalQuantityOfNewsException {

		if (numberOfNews <= 0) {
			throw new IllegalQuantityOfNewsException();
		}

		if (numberOfNews % 10 > 0) {
			System.out.println("You need " + ((numberOfNews / QUANTITY_NEWS_ON_PAGE) + 1) + " page(s) ");

		}

		else {

			System.out.println("You need " + (numberOfNews / QUANTITY_NEWS_ON_PAGE) + " page(s) ");
		}

	}
}

class IllegalQuantityOfNewsException extends Exception {

	 private String exceptionMessage = "Quantity of news sholud be greater then zero";

	public String getExceptionMessage() {
		return exceptionMessage;
	}

}
