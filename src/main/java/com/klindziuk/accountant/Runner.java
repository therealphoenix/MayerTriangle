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

	private static Warehouse warehouse;
	private static BufferedReader reader;
	private static Runner runner;
	private boolean inputCorrect;
	private boolean isExit;

	public static void main(String[] args) throws IOException {

		runner = new Runner();
		runner.menu();

	}

	// main menu
	private int menu() throws IOException {
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

		}
		scanner.close();
		return selection;

	}

	public void fillWarehouse() throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			inputCorrect = false;
			isExit = false;

			String type = runner.addType();
			if (isExit) {
				break;
			}
			String name = runner.addName();
			if (isExit) {
				break;
			}
			int quantity = runner.addQuantity();
			if (isExit) {
				break;
			}
			float price = runner.addPrice();
			if (isExit) {
				break;
			}

			Good good = new Good(type, name, quantity, price);
			warehouse.addGood(good);
			System.out.println("Good " + name + " successfully added.");
		}
	}

	public String addType() throws IOException {
		String type = "";

		do {
			System.out.print("Input TYPE of good or \"stop\" to end of data input: ");

			type = reader.readLine();

			if (type.length() > 36) {
				System.out.println("incorrect input in field \"TYPE\".Size of type sholud be less than 36 symbols.");
			} else {
				inputCorrect = true;
			}

			if ("stop".equals(type)) {
				isExit = true;
				break;
			}

		} while (!inputCorrect);

		return type;
	}

	public String addName() throws IOException {

		String name = "";
		inputCorrect = false;
		do {
			System.out.print("Input NAME of good or \"stop\" to end of data input: ");

			name = reader.readLine();

			if (name.length() > 36) {
				System.out.println("incorrect input in field \"NAME\".Size of type sholud be less than 36 symbols.");
			} else {
				inputCorrect = true;
			}

			if ("stop".equals(name)) {
				isExit = true;
				break;
			}

		} while (!inputCorrect);

		return name;

	}

	public int addQuantity() throws IOException {

		int quantity = 0;
		inputCorrect = false;

		do {
			System.out.print("Please input QUANTITY of good or \"stop\" to end of data input:  ");
			try {
				String line = reader.readLine();
				if ("stop".equals(line)) {
					isExit = true;
					break;
				}

				quantity = Integer.parseInt(line);

				if (quantity <= 0) {
					System.out.println("incorrect input in field \"QUANTITY\".Quantity sholud be greater than zero.");
				}

				else {
					inputCorrect = true;
				}
			} catch (NumberFormatException ex) {
				System.out.println("Incorrect input in field \"QUANTITY\".Input Integer greater than zero");
			}
		} while (!inputCorrect);

		return quantity;
	}

	public float addPrice() throws IOException {
		float price = 0;
		inputCorrect = false;
		do {
			System.out.print("Please input PRICE of good or \"stop\" to end of data input:  ");
			try {
				String line = reader.readLine();
				if ("stop".equals(line)) {
					isExit = true;
					break;
				}

				price = Float.parseFloat(line);

				if (price <= 0) {
					System.out.println("Incorrect input in field \"PRICE\".Quantity sholud be greater than zero.");
				} else {
					inputCorrect = true;
				}

			} catch (NumberFormatException ex) {
				System.out.println("Incorrect input in field \"PRICE\".Input number greater than zero");
			}

		} while (!inputCorrect);

		return price;
	}
}
