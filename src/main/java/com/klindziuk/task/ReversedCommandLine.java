package com.klindziuk.task;

/*
 * Модифицируйте код программы так, чтобы параметры командной строки выводились в обратном порядке.
 */

public class ReversedCommandLine {

	public static void main(String[] args)

	{

		for (int i = args.length - 1; i >= 0; i--) {
			System.out.println("Argument " + i + " = " + args[i]);
		}
	}

}
