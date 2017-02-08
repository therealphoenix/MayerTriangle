package com.klindziuk.task;

public class QuadraticEquation {

	public static void main(String[] args) {
		double a = 2;
		double b = 3;
		double c = 4;

		try {

			if (Math.pow(b, 2) - (4 * a * c) < 0) {
				throw new UnsupportedOperationException();
			}
			double x1 = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;
			double x2 = (b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;

			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);

		} catch (UnsupportedOperationException ex) {
			System.out.print("There are no real roots in this equation.");
		}

	}

}
