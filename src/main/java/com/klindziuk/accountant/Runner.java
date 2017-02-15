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
	
	private static Runner runner;
	private Warehouse warehouse;
	private BufferedReader reader;
	private boolean isExit;

	public static void main(String[] args) throws IOException {

		runner = new Runner();
		runner.menu();
	    	}

	// main menu
	private  int menu() throws IOException {
		this.warehouse = new Warehouse();

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
			
			isExit = false;
			System.out.print("Input TYPE of good or \"stop\" to end of data input: ");
			String type = runner.inputString(36);
			if (isExit) {
				break;
			}
			System.out.print("Input NAME of good or \"stop\" to end of data input: ");
			String name = runner.inputString(36);
			if (isExit) {
				break;
			}
			System.out.print("Please input QUANTITY of good or \"stop\" to end of data input:  ");
			int quantity = (int) runner.inputNumber();
			if (isExit) {
				break;
			}
			float price = (float) runner.inputNumber();
			if (isExit) {
				break;
			}

			Good good = new Good(type, name, quantity, price);
			warehouse.addGood(good);
			System.out.println("Good " + name + " successfully added.");
		}
	}

	public String inputString(int allowedNumberOfsymbols) throws IOException {
		String line = "";
		boolean inputCorrect = false;
		
		do {

			line = reader.readLine();
			if (shouldStop(line)) {
				isExit = true;
				break;
			}

			if (line.length() > allowedNumberOfsymbols) {
				System.out.println("Incorrect input in field.Size of type sholud be less than 36 symbols.");
				System.out.print("Input TYPE of good or \"stop\" to end of data input: ");
			} else {
				inputCorrect = true;
			}
			
		} while (!inputCorrect);

		return line;
	}


	public float inputNumber() throws IOException {

		float number = 0f;
		boolean inputCorrect = false;

		do {
			
			try {
				
				String line = reader.readLine();
				if (shouldStop(line)) {
					isExit = true;
					break;
				}

				number = Float.parseFloat(line);

				if (number <= 0) {
					System.out.println("incorrect input in field.Number shoud be greater than zero.");
				}

				else {
					inputCorrect = true;
				}
			} catch (NumberFormatException ex) {
				System.out.println("Incorrect input in field .Input Number greater than zero");
			}
		} while (!inputCorrect);

		return number;
	}

	
	boolean shouldStop(String line) {
	    return "stop".equals(line);
	}
}
