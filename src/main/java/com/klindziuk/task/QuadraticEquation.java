package com.klindziuk.task;

/*
 * Найти действительные корни квадратного уравнения ax2 + bx + c = 0.
 * Корректно обработать случай, когда дискриминант равен нулю.
 * 
 */

public class QuadraticEquation {
	
	public static void main(String[] args) {
		

		try {
			
			double a = Double.parseDouble(args[0]);
			double b = Double.parseDouble(args[1]);
			double c = Double.parseDouble(args[2]);
			

			if ((Math.pow(b, 2) - (4 * a * c)) < 0) {
				throw new UnsupportedOperationException();
				
			}
			if ((Math.pow(b, 2) - (4 * a * c)) == 0) {
				System.out.println("x1 = x2 = " + -b);
				
		}
			else {
			
			double x1 = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;
			double x2 = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / 2 * a;

			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
			}

		} catch (UnsupportedOperationException ex) {
			System.out.print("There are no real roots in this equation.");
			
					
		}
		  catch (NumberFormatException ex) {
			System.out.println("Only numbers allowed");

	}

}

}