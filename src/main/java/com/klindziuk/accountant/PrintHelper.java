package com.klindziuk.accountant;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PrintHelper {
	
	public static final String SEPARATOR = System.getProperty("line.separator");
	
	static void print(List<Good> warehouseList) {
		if ((null == warehouseList) ||  0 == warehouseList.size() ) {
			System.out.println("DATA LIST IS EMPTY.");
		}

		else {

			for (Good good : warehouseList) {
				System.out.println(good);
			}
			System.out.println();
		}
	}

	static void print(String message, int quantityOFTypes) {

		if (0 == quantityOFTypes) {
			System.out.println("DATA IS NULL");
		}

		else {
			System.out.println(SEPARATOR + message + ": "  + quantityOFTypes);
		}

	}

	static void print(int quantityOfAllGoods, String message) {

		if (0 == quantityOfAllGoods) {
			System.out.println("DATA IS NULL");
		}

		else {
			System.out.println(SEPARATOR + message + ": " + quantityOfAllGoods);

		}
	}

	static void print(String message, double averagePriceOfAllGoods) {
		if (0 == averagePriceOfAllGoods) {
			System.out.println("DATA IS NULL");
		}

		else {
			System.out.println(SEPARATOR + message + ": " + averagePriceOfAllGoods);

		}

	}

	static void print(String message, Map<String, Float> averagePriceMap) {

		if (0 == averagePriceMap.size()) {
			System.out.println("DATA MAP IS EMPTY");
		}

		else {

			for (Entry<String, Float> entry : averagePriceMap.entrySet()) {

				System.out.println(
						SEPARATOR + message + entry.getKey() + ": " + entry.getValue());
			}
		}
		System.out.println();
		

	}
}
