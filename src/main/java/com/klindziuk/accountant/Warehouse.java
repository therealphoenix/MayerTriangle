package com.klindziuk.accountant;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Warehouse {
	
	private BufferedReader reader;
	private List<Good> listOfGoods;

	public List<Good> getListOfGoods() {
		return listOfGoods;
	}

	public void setListOfGoods(List<Good> listOfGoods) {
		this.listOfGoods = listOfGoods;
	}
	
	public Warehouse() {
		this.listOfGoods = new ArrayList<>();
	}

	public void fillWarehouse() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		

		while (true) {

			try {

				System.out.print("Please input type of good or \"stop\" to end of data input: ");
				String type = reader.readLine();

				if ("stop".equals(type)) {
					
					break;
				}
				System.out.print("Please input name of good: ");
				String name = reader.readLine();
				System.out.print("Please input quantity of good: ");
				int quantity = Integer.parseInt(reader.readLine());
				
				if(quantity < 0) {
					throw new IllegalArgumentException();
				}
					
				System.out.print("Please input price of good: ");
				float price = Float.parseFloat(reader.readLine());
				
				if(price < 0) {
					throw new IllegalArgumentException();
				}
				Good good = new Good(type, name, quantity, price);
				this.listOfGoods.add(good);
				System.out.println("Good " + name + " successfully added.");
			}

			catch (NumberFormatException nfex) {
				System.out.println("Bad data.For fields \"price\" and \"quantity\" you should input numbers.");
			} catch (IOException ioex) {
				ioex.printStackTrace();
			}
		}

		
	}


	public int getQuantityOfTypes(List<Good> listOfGoods) {

		Set<String> setOfTypes = new HashSet<>();

		for (Good good : listOfGoods) {
			setOfTypes.add(good.getType());
		}

	//	System.out.println("Quantity of types is: " + setOfTypes.size()); // for
																			// testing
																			// for
																			// testing
																			// i'll
																			// remove
																			// it
																			// later

		return setOfTypes.size();
	}

	public int getQuantityOfAllGoods(List<Good> listOfGoods) {

		int result = 0;

		for (Good good : listOfGoods) {
			result = result + good.getQuantity();
		}

	//	System.out.println("Quantity of all goods is: " + result); // for
																	// testing
																	// i'll
																	// remove it
																	// later

		return result;
	}

	public double getAveragepriceOfAllGoods(List<Good> listOfGoods) {

		double sumOfprice = 0;
		int quantityOfAllgoods = 0;

		for (Good good : listOfGoods) {
			sumOfprice = sumOfprice + good.getPrice();
			quantityOfAllgoods = quantityOfAllgoods + good.getQuantity();
		}

	//	System.out.println("Average price of all goods: " + (sumOfprice / quantityOfAllgoods)); // -
																								// ==
																								// -

		return (sumOfprice / quantityOfAllgoods);
	}

	public Map<String, Float> getAveragePriceForEachType(List<Good> listOfGoods) { // вот
																					// здесь
																					// надо
																					// помучаться
																					// и
																					// придумать
																					// что
																					// вернуть,
																					// отделив
		// бизнес логику от общения с пользователем

		Set<Good> setOfGoods = new HashSet<>();
		Map<String, Float> averagePriceMap = new HashMap<>();

		for (Good good : listOfGoods) {
			setOfGoods.add(good);
		}

		for (Good good : setOfGoods) {

			float sumOfPrice = 0;
			int quantityOfAllgoods = 0;

			for (Good g : listOfGoods) {

				if (good.getType().equals(g.getType())) {
					sumOfPrice = sumOfPrice + g.getPrice();
					quantityOfAllgoods = quantityOfAllgoods + g.getQuantity();
				}

			}

	//		System.out.println("Average price for " + good.getType() + ": " + (sumOfPrice / quantityOfAllgoods)); // for
																													// testing
			averagePriceMap.put(good.getType(), (sumOfPrice / quantityOfAllgoods));
		}

		return averagePriceMap;
	}

}
