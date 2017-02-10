package com.klindziuk.accountant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 *  Напишите «небольшую бухгалтерскую программу», принимающую с клавиатуры информацию о товарах 
 *  (тип, наименование, количество, стоимость одной единицы). При получении некоторой команды 
 *  (реализуйте на своё усмотрение) программа должна выдать следующую информацию:
    количество типов товаров;
• 	общее количество товаров;
•	 средняя стоимость товара;
•	 средняя стоимость товара каждого типа.
 * 
 * 
 * 
 * 
 */

public class Runner {
	BufferedReader reader;

	public static void main(String[] args) throws IOException {

		Calculator calculator = new Calculator();

		System.out.println();
		calculator.setListOfGoods(new Runner().setData());
		for (Good g : calculator.getListOfGoods()) {
			System.out.println(g);
		}

		calculator.getQuantityOfTypes(calculator.getListOfGoods());
		calculator.getQuantityOfAllGoods(calculator.getListOfGoods());
		calculator.getAveragepriceOfAllGoods(calculator.getListOfGoods());
		calculator.getAveragepriceForAnyType(calculator.getListOfGoods());

	}

	public List<Good> setData() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		List<Good> listOfGoods = new ArrayList<>();

		while (true) {

			try {

				System.out.print("Please input type of good or \"exit\" to quit: ");
				String type = reader.readLine();

				if ("exit".equals(type)) {
					reader.close();
					break;
				}
				System.out.print("Please input name of good: ");
				String name = reader.readLine();
				System.out.print("Please input quantity of good: ");
				int quantity = Integer.parseInt(reader.readLine());
				System.out.print("Please input price of good: ");
				double price = Double.parseDouble(reader.readLine());
				Good good = new Good(type, name, quantity, price);
				listOfGoods.add(good);
				System.out.println("Good " + name + " successfully added.");
			}

			catch (NumberFormatException nfex) {
				System.out.println("Bad data.For fields \"price\" and \"quantity\" you should input numbers.");
			} catch (IOException ioex) {
				ioex.printStackTrace();
			}
		}

		return listOfGoods;
	}

}
