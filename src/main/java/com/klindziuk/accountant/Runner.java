package com.klindziuk.accountant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
 */

public class Runner {
	 

	public static void main(String[] args) throws IOException {

		
		menu();

	}

	// main menu
	private static int menu() {
		Warehouse warehouse = new Warehouse();
		Printer printer = new Printer();

		Scanner scanner = new Scanner(System.in);
		
		int selection = 0;
		int i = 0;
		
		while ( i == 0) {
			
			System.out.println("Please choose an option :");
			System.out.println("[1] Add good to warehouse");
			System.out.println("[2] View all");
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
				warehouse.fillWarehouse();
				break;

			case 2:
				printer.printListOfAllgoods(warehouse.getListOfGoods());
				break;
			case 3:
				printer.printQuantityOfTypes(warehouse.getQuantityOfTypes(warehouse.getListOfGoods()));
				break;
			case 4:
				printer.printQuantityOFAllGoods(warehouse.getQuantityOfAllGoods(warehouse.getListOfGoods()));
				break;
			case 5:
				printer.printAveragePriceOfAllGoods(warehouse.getAveragepriceOfAllGoods(warehouse.getListOfGoods()));
				break;
			case 6:
				printer.printAveragePriceForEachType(warehouse.getAveragePriceForEachType(warehouse.getListOfGoods()));
				break;
			case 0:
				System.out.println("See you later!");
				System.exit(0);
				break;

			default:
				System.out.println("Make valid choice!");
			}
	}
			catch (IllegalArgumentException iaex) {
				System.out.println("Bad data. Fields \"price\" and \"quantity\" should be greater than zero");
			}
			
			catch (NullPointerException npex) {
				System.out.println("Warehouse is empty");
			}
		}
		scanner.close();
		return selection;
			
	
		
		
	}

}
