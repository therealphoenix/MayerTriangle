package com.klindziuk.traingle;

public class Triangle {

	private int sideA;
	private int sideB;
	private int sideC;

	public Triangle(int[] sideArray) {

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

	public boolean isScaleneTriangle(int sideA, int sideB, int sideC) {

		if (((sideA + sideB) > sideC) && ((sideB + sideC) > sideA) && ((sideA + sideC) > sideB) && (sideA != sideB)
				&& (sideA != sideC) && (sideB != sideC))

		{

			System.out.println("Triangle is Scalene and correct.");
			return true;
		} else

			return false;
	}

	public boolean isEquilateralTriangle(int sideA, int sideB, int sideC) {

		if ((sideA == sideB) && (sideA == sideC) && (sideB == sideC)) {

			System.out.println("Triangle is Equilateral and correct.");
			return true;
		} else
			return false;

	}

	public boolean isIsoscelesTriangle(int sideA, int sideB, int sideC) {

		if ((sideA == sideB) || (sideB == sideC) || (sideA == sideC)) {

			System.out.println("Triangle is Isosceles and correct.");
			return true;
		}

		else
			return false;

	}

	public void decideTriangleType(Triangle triangle) {

		isIsoscelesTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
		isEquilateralTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
		isScaleneTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());

	}

}
