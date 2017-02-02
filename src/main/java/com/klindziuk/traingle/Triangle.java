package com.klindziuk.traingle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
		
	private int sideA;
	private int sideB;
	private int sideC;
	
	
	public Triangle() {
	
	int [] sideArray = inputSides();	
	
		
		this.sideA = sideArray[0];
		this.sideB = sideArray[1];
		this.sideC = sideArray[2];
		
	}		
	public void setSideA(int sideA) {
		this.sideA = sideA;
	}

	public void setSideB(int sideB) {
		this.sideB = sideB;
	}

	public void setSideC(int sideC) {
		this.sideC = sideC;
	}

	public int getSideA() {
		return sideA;
	}
	
	
	public int getSideB() {
		return sideB;
	}
	
		
	public int getSideC() {
		return sideC;
	}
	
	public int[] inputSides(){
		
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int arrayOfsides[] = new int [3];
		
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
		
		if((SideChecker.CheckSides(a, b, c) && SideChecker.checkSumOfSides(a,b,c))){
			System.out.println("Sides are correct, we can create triangle.");
			
			this.sideA = a;
			this.sideB = b;
			this.sideC = c;
			
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
		
		return arrayOfsides;
	}
	
	public boolean isScaleneTriangle(int sideA, int sideB, int sideC) {
		
		if(((sideA + sideB) > sideC) && ((sideB + sideC) > sideA) && ((sideA + sideC) > sideB) &&
		(sideA != sideB) && (sideA != sideC) && (sideB != sideC))
		
		{
		
		System.out.println("Triangle is Scalene and correct.");	
		return true;
		}
		else 
			
		return false;
		}
		
	public boolean isEquilateralTriangle(int sideA, int sideB, int sideC){
		
		if((sideA == sideB) && (sideA == sideC) && (sideB == sideC)) {
			
		System.out.println("Triangle is Equilateral and correct.");
		return true;
	}
		else 
			 return false;
	
}
	public boolean isIsoscelesTriangle(int sideA, int sideB, int sideC){
		
		if((sideA == sideB) || (sideB == sideC) || (sideA == sideC)){
			
			
			System.out.println("Triangle is Isosceles and correct.");
			return true;
		}
		
		else 
			return false;
		
	}
	
	public void decideTriangleType(Triangle triangle){
		
		isIsoscelesTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
		isEquilateralTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
		isScaleneTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
		
		
	}
	
}
