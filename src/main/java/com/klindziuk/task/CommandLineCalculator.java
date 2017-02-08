package com.klindziuk.task;

/*
 * Напишите «калькулятор», который принимает из командной строки два числа
 * и операцию ("число операция число") выводит в консоль результат выражения.
 */

public class CommandLineCalculator {

	public static void main(String[] args) {

		try {
			/*
			 * We should wrap our expression in "" because if we use operation
			 * " * " in command line without "" args[] will be contain  names
			 * of all files in current directory"
			 * 
			 */
			String[] expression = args[0].split(" ");

			if (expression.length > 3) {
				throw new IllegalArgumentException();
			}

			float firstNumber = Float.parseFloat(expression[0]);
			float secondNumber = Float.parseFloat(expression[2]);

			String operation = expression[1];

			if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
				throw new UnsupportedOperationException();
			}

			switch (operation) {
			case "+":
				System.out.println(firstNumber + " + " + secondNumber + " " + "= " + (firstNumber + secondNumber));
				break;

			case "-":
				System.out.println(firstNumber + " - " + secondNumber + " " + "= " + (firstNumber - secondNumber));
				break;

			case "*":
				System.out.println(firstNumber + " * " + secondNumber + " " + "= " + (firstNumber * secondNumber));
				break;
			case "/":
				System.out.println(firstNumber + " / " + secondNumber + " " + "= " + (firstNumber / secondNumber));
				break;

			}

		}

		 catch (ArrayIndexOutOfBoundsException aiobex) {
			System.out.println("Please, put your expression in \" \". ");
		}

		 catch (NumberFormatException ex) {
			System.out.println("Only numbers allowed");
			
		} catch (IllegalArgumentException iaex) {
			System.out.println("To much arguments");
			
		} catch (UnsupportedOperationException uoex) {
			System.out.println("Only + - * / operations are allowed");
		}

	}

}
