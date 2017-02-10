package com.klindziuk.accountant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
			System.out.println("Bad data.please input numbers");
		}
				catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}

		

		return listOfGoods;
	}

			

	}
	
	
