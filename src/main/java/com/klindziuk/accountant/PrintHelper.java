package com.klindziuk.accountant;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public  class PrintHelper {
	public static final String EMPTY_WAREHOUSE_MESSAGE = "\nWarehouse is empty.";
	

	void printListOfAllgoods(List<Good> warehouseList) {
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

	void printQuantityOfTypes(String message, int quantityOFTypes) {

		if (0 == quantityOFTypes) {
			System.out.println(EMPTY_WAREHOUSE_MESSAGE);
		}

		else {
			System.out.println(System.getProperty("line.separator") + message + ": " +  + quantityOFTypes);
		}

	}

	void printQuantityOFAllGoods(String message, int quantityOfAllGoods) {

		if (0 == quantityOfAllGoods) {
			System.out.println(EMPTY_WAREHOUSE_MESSAGE);
		}

		else {
			System.out.println(System.getProperty("line.separator") + message + ": " +  quantityOfAllGoods);
			

		}
	}

	void printAveragePriceOfAllGoods(String message, double averagePriceOfAllGoods) {
		if (0 == averagePriceOfAllGoods)  {
			System.out.println(EMPTY_WAREHOUSE_MESSAGE);
		}

		else {
			System.out.println(System.getProperty("line.separator") + message + ": " +  averagePriceOfAllGoods);
			
		}

	}

	void printAveragePriceForEachType(String message, Map<String, Float> averagePriceMap) {

		if (0 == averagePriceMap.size()) {
			System.out.println(EMPTY_WAREHOUSE_MESSAGE);
		}

		else {

			for (Entry<String, Float> entry : averagePriceMap.entrySet()) {

				System.out.print(System.getProperty("line.separator") + message + entry.getKey() + ": " + entry.getValue());
			}
		}
		System.out.println();

	}
}
