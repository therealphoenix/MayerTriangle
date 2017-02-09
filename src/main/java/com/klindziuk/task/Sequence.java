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

	// int firstNumber = Integer.parseInt(String.valueOf(array[0]));
	// int secondNumber = Integer.parseInt(String.valueOf(array[1]));
	// int preLastNumber = Integer.parseInt(String.valueOf(array[array.length -
	// 2]));
	// int lastNumber = Integer.parseInt(String.valueOf(array[array.length -
	// 1]));
	//
	// System.out.println(firstNumber);
	// System.out.println(secondNumber);
	// System.out.println(preLastNumber);
	// System.out.println(lastNumber);
	//
	// if((firstNumber < secondNumber) && (lastNumber > preLastNumber)) {
	//
	// System.out.println("Sequence is growing");
	//
	// }
	//
	// else {
	//
	// System.out.println ("Sequence is not growing");
	// }
	//
	//

}
