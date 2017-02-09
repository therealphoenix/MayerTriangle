package com.klindziuk.task;

/*
 * 
 * Написать метод, определяющий площадь круга с радиусом X.
 * 
 */

import java.util.Random;

public class CircleSquare {

	public double getCircleSquare(double radius) throws IllegalRadiusException {

		double result = 0;

		if (radius <= 0) {
			throw new IllegalRadiusException();
		}

		result = (Math.PI * Math.pow(radius, 2));

		return result;

	}

}

class IllegalRadiusException extends Exception {

	 private String exceptionMessage = "Radius sholud be greater then zero";

	public String getExceptionMessage() {
		return exceptionMessage;
	}

}

