package com.klindziuk.accountant;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PrintHelper {
	
	public static final String SEPARATOR = System.getProperty("line.separator");
	
	static void print(List<Good> list) {
		if ((null == list) ||  0 == list.size() ) {
			System.out.println("DATA LIST IS EMPTY.");
		}

		else {

			for (Good good : list) {
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
	
	static void print(String message, String value) {

		if (null == value) {
			System.out.println("DATA IS NULL");
		}

		else {
			System.out.println(SEPARATOR + message  + value);
		}

	}

	static void print(String message, Map<String, Float> map) {

		if ( null == map || 0 == map.size()) {
			System.out.println("DATA MAP IS EMPTY");
		}

		else {

			for (Entry<String, Float> entry : map.entrySet()) {

				System.out.print(
						SEPARATOR + message + entry.getKey() + ": " + entry.getValue());
			}
		}
		 System.out.print(SEPARATOR);
	
		

	}
}
