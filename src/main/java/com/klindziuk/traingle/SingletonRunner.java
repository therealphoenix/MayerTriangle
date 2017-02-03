package com.klindziuk.traingle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingletonRunner {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("Please input sides of triangle, they should be greater then 0 ! ");

			try {

				System.out.print("Please input first side: ");
				int a = Integer.parseInt(reader.readLine());

				System.out.print("Please second side: ");
				int b = Integer.parseInt(reader.readLine());

				System.out.print("Please input third side: ");
				int c = Integer.parseInt(reader.readLine());
				System.out.println();

				if (SingletonTriangle.init(a, b, c)){
					
					reader.close();
					break;

				}
				System.out.println("Sides are incorrect, we can't create triangle, please try again:");
				System.out.println();
			}

			catch (NumberFormatException ex) {

				System.out.println("Only numbers allowed, please try again:");
			}

			catch (IOException ioex) {
				ioex.printStackTrace();
			}

		}

		SingletonTriangle triangle = SingletonTriangle.getInstance();
		triangle.decideTriangleType(triangle);

	}

}
