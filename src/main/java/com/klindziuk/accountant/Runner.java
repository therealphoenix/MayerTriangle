package com.klindziuk.accountant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *  Напишите «небольшую бухгалтерскую программу», принимающую с клавиатуры информацию о товарах 
 *  (тип, наименование, количество, стоимость одной единицы). При получении некоторой команды 
 *  (реализуйте на своё усмотрение) программа должна выдать следующую информацию:
    количество типов товаров;
 	общее количество товаров;
	 средняя стоимость товара;
	 средняя стоимость товара каждого типа.
 * 
 * 
 */

public class Runner {
	static Warehouse warehouse;

	public static void main(String[] args) throws IOException {

		menu();

	}

	// main menu
	private static int menu() throws IOException {
		warehouse = new Warehouse();

		Scanner scanner = new Scanner(System.in);

		int selection = 0;
		int i = 0;

		while (i == 0) {

			System.out.println("Please choose an option :");
			System.out.println("[1] Add good to warehouse");
			System.out.println("[2] View all goods");
			System.out.println("[3] View quantity of types");
			System.out.println("[4] View quantity of all goods");
			System.out.println("[5] View average price of all goods");
			System.out.println("[6] View average price for each type of goods");
			System.out.println("[0] Quit");
			System.out.print("Choice: ");

			try {
				selection = scanner.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Sorry,only numbers allowed.");
			}

			try {
				switch (selection) {

				case 1:
					fillWarehouse();
					break;
				case 2:
					PrintHelper.print(warehouse.getListOfGoods());
					break;
				case 3:
					PrintHelper.print("Quantity of types is: ", warehouse.getQuantityOfTypes());
					break;
				case 4:
					PrintHelper.print(warehouse.getQuantityOfAllGoods(), "Quantity of all goods is: ");
					break;
				case 5:
					PrintHelper.print("Average price of all goods: ", warehouse.getAveragepriceOfAllGoods());
					break;
				case 6:
					PrintHelper.print("Average price for ", warehouse.getAveragePriceForEachType());
					break;
				case 0:
					System.out.println("See you later!");
					System.exit(0);
					break;

				default:
					System.out.println("Make valid choice!");
				}

			} catch (IllegalArgumentException iaex) {
				System.out.println("Bad data. Field \"quantity\" should be greater than zero");
			} catch (InputMismatchException iaex) {
				System.out.println("Bad data. Field \"price\" should be greater than zero");
			}

		}
		scanner.close();
		return selection;

	}

	public static void fillWarehouse() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean isExit = false;

		while (true) {
			String type = "";
			String name = "";
			int quantity = 0;
			float price = 0;
			boolean inputCorrect = false;

			// input type
			do {
				System.out.print("Input type of good or \"stop\" to end of data input: ");
				try {
					type = reader.readLine();
					inputCorrect = true;

					if ("stop".equals(type)) {
						isExit = true;
						break;
					}

				} catch (Exception e) {
					System.out.println("incorrect input in field \"type\" ");

				}
			} while (!inputCorrect);

			if (isExit) {
				break;
			}

			// input name
			do {
				System.out.print("Please input name of good or \"stop\" to end of data input:  ");
				try {
					name = reader.readLine();
					inputCorrect = true;

					if ("stop".equals(name)) {
						isExit = true;
						break;
					}

				} catch (Exception e) {
					System.out.println("incorrect input in field \"name\" ");

				}

			} while (!inputCorrect);

			if (isExit) {
				break;
			}

			// input quantity
			do {
				System.out.print("Please input quantity of good or \"stop\" to end of data input:  ");
				try {
					String line = reader.readLine();
					if ("stop".equals(line)) {
						isExit = true;
						break;
					}

					quantity = Integer.parseInt(line);
					inputCorrect = true;

					if (quantity < 0) {
						inputCorrect = false;
						throw new IllegalArgumentException();

					}

				} catch (NumberFormatException ex) {
					System.out.println("incorrect input in field \"quantiry\" ");

				} catch (IllegalArgumentException iaex) {
					System.out.println("Bad data. Field \"quantity\" should be greater than zero");
				}

			} while (!inputCorrect);

			if (isExit) {
				break;
			}

			do {
				System.out.print("Please input price of good or \"stop\" to end of data input:  ");
				try {
					String line = reader.readLine();
					if ("stop".equals(line)) {
						isExit = true;
						break;
					}

					price = Float.parseFloat(line);
					inputCorrect = true;

					if (price < 0) {
						inputCorrect = false;
						throw new InputMismatchException();
					}

				} catch (NumberFormatException ex) {
					System.out.println("incorrect input in field \"price\" ");

				} catch (InputMismatchException iaex) {
					System.out.println("Bad data. Field \"price\" should be greater than zero");
				}
			} while (!inputCorrect);

			if (isExit) {
				break;
			}

			Good good = new Good(type, name, quantity, price);
			warehouse.addGoods(good);
			System.out.println("Good " + name + " successfully added.");
		}
	}

}
