package com.klindziuk.task;

/*
 * Написать метод, возвращающий N-значное целое случайное число.
 */

import java.util.Random;

public class RandomNumber {



public int getRandomNdigitNumber(int numberOfDigits) throws IllegalNumberOfDigitsException {

	if (numberOfDigits <= 0) {

		throw new IllegalNumberOfDigitsException();

	}
	Random generator = new Random();

	return generator.nextInt((int) Math.pow(10, numberOfDigits));

}
}
class IllegalNumberOfDigitsException extends Exception {

	 
	private String exceptionMessage = "Quantity of digits should be greater then zero";

	public String getExceptionMessage() {
		return exceptionMessage;
	}

}