package com.klindziuk.traingle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MayersRunner {

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

				MayersTriangle.init(a, b, c);
					
					reader.close();
					break;
			}

			catch (NumberFormatException ex) {

				System.out.println("Only numbers allowed, please try again:");
			}
			
			catch (IllegalArgumentException iaex) {
				
				System.out.println("Unfortunately we can't create triangle with this sides, please try again");
			}

			catch (IOException ioex) {
				ioex.printStackTrace();
			}

		}

		MayersTriangle triangle = MayersTriangle.getInstance();
		triangle.decideTriangleType(triangle);

	}

}
