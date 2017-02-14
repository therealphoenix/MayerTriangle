package com.klindziuk.accountant;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PrintHelper {
	public static final String EMPTY_WAREHOUSE_MESSAGE = "\nWarehouse is empty.";

	static void print(List<Good> warehouseList) {
		if (0 == warehouseList.size()) {
			System.out.println(EMPTY_WAREHOUSE_MESSAGE);
		}

		else {

			for (Good g : warehouseList) {
				System.out.println(g);
			}
			System.out.println();
		}
	}

	static void print(String message, int quantityOFTypes) {

		if (0 == quantityOFTypes) {
			System.out.println(EMPTY_WAREHOUSE_MESSAGE);
		}

		else {
			System.out.println(System.getProperty("line.separator") + message + ": "  + quantityOFTypes);
		}

	}

	static void print(int quantityOfAllGoods, String message) {

		if (0 == quantityOfAllGoods) {
			System.out.println(EMPTY_WAREHOUSE_MESSAGE);
		}

		else {
			System.out.println(System.getProperty("line.separator") + message + ": " + quantityOfAllGoods);

		}
	}

	static void print(String message, double averagePriceOfAllGoods) {
		if (0 == averagePriceOfAllGoods) {
			System.out.println(EMPTY_WAREHOUSE_MESSAGE);
		}

		else {
			System.out.println(System.getProperty("line.separator") + message + ": " + averagePriceOfAllGoods);

		}

	}

	static void print(String message, Map<String, Float> averagePriceMap) {

		if (0 == averagePriceMap.size()) {
			System.out.println(EMPTY_WAREHOUSE_MESSAGE);
		}

		else {

			for (Entry<String, Float> entry : averagePriceMap.entrySet()) {

				System.out.print(
						System.getProperty("line.separator") + message + entry.getKey() + ": " + entry.getValue());
			}
		}
		System.out.println();

	}
}
