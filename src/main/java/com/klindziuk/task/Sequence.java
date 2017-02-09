package com.klindziuk.task;

/*
 *  Написать программу, определяющую, образуют ли цифры некоторого числа
 *  возрастающую последовательность.
 *  Например: 123 – образуют, 212 – не образуют.
 * 
 */

public class Sequence {

	public static void main(String[] args) {

		System.out.println(decideSequence(args[0]));

	}

	public static String decideSequence(String number) {

		char[] charArray = number.toCharArray();

		String result = "";

		for (int j = 0; j < charArray.length - 1; j++) {

			if (charArray[j] > charArray[j + 1]) {

				result = number + " - Sequence is not growing.";
				break;
			} else {

				result = number + " - Sequence is growing.";
			}

		}

		return result;
	}
}

	