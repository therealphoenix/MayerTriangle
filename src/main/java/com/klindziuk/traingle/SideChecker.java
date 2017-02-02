package com.klindziuk.traingle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SideChecker {
	protected static int sideA;
	protected static int sideB;
	protected static int sideC;
	
	
	public static void inputAndCheckSides()  {
		BufferedReader	reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
		System.out.println("Please input sides of triangle, they should be greater then 0 ! ");
		
			
		try	 {
			
		System.out.print("Please input first side: ");
		int a = Integer.parseInt(reader.readLine());
		
		System.out.print("Please second side: ");
		int b = Integer.parseInt(reader.readLine());
		
		System.out.print("Please input third side: ");
		int c = Integer.parseInt(reader.readLine());
		System.out.println();
		
		if((a > 0) && (b > 0) && (c > 0) && checkSumOfSides(a,b,c)){
			System.out.println("Sides are correct, we can create triangle.");
			
			sideA = a;
			sideB = b;
			sideC = c;
			
			reader.close();
			break;
		}
		 System.out.println("Sides are incorrect, we can't create triangle, please try again:");
		 System.out.println();
		}
		
		 catch (NumberFormatException ex){
		
			System.out.println("Only numbers allowed, please try again:");
		 }
		
		catch ( IOException ioex) {
			ioex.printStackTrace();
		}
		}
		
		
	}
	
	public static boolean checkSumOfSides(int sideA, int sideB, int sideC){
		
		if((sideA + sideB <= sideC) || (sideB + sideC <= sideA) || (sideA + sideC <= sideB))
		{
			System.out.println("Can not create triangle with this sides");
			return false;
		}
		
		else
			
			return true;
		
	}
	
	

}
