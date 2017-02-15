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

	static void print(String message, int value) {

		if (0 == value) {
			System.out.println("DATA IS NULL");
		}

		else {
			System.out.println(SEPARATOR + message + ": "  + value);
		}

	}

	static void print(int value, String message) {

		if (0 == value) {
			System.out.println("DATA IS NULL");
		}

		else {
			System.out.println(SEPARATOR + message + ": " + value);

		}
	}

	static void print(String message, double value) {
		if (0 == value) {
			System.out.println("DATA IS NULL");
		}

		else {
			System.out.println(SEPARATOR + message + ": " + value);

		}

	}

	static void print(String message, Map<String, Float> averagePriceMap) {

		if ( null == averagePriceMap || 0 == averagePriceMap.size()) {
			System.out.println("DATA MAP IS EMPTY");
		}

		else {

			for (Entry<String, Float> entry : averagePriceMap.entrySet()) {

				System.out.println(
						SEPARATOR + message + entry.getKey() + ": " + entry.getValue());
			}
		}
	
		

	}
}
