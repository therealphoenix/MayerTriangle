package com.klindziuk.traingle;

public class SingletonTriangle {

	private static SingletonTriangle singletonTriangle;

	private int sideA;
	private int sideB;
	private int sideC;

	public int getSideA() {
		return sideA;
	}

	public int getSideB() {
		return sideB;
	}

	public int getSideC() {
		return sideC;
	}

	private SingletonTriangle(int sideA, int sideB, int sideC) {
		this.sideA = sideA;
		this.sideA = sideB;
		this.sideA = sideC;
	}

	public static void init(int sideA, int sideB, int sideC) throws NumberFormatException {
		
		singletonTriangle = null;
		
		if((SideChecker.CheckSides(sideA, sideB, sideC) && SideChecker.checkSumOfSides(sideA, sideB, sideC))) {
			System.out.println("Sides are correct, we can create triangle.");
				singletonTriangle = new SingletonTriangle(sideA, sideB, sideC);
		}
				else throw new NumberFormatException();
		}
		
	public static SingletonTriangle getInstance() {
		return singletonTriangle;
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

	public void decideTriangleType(SingletonTriangle triangle) {

		isIsoscelesTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
		isEquilateralTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
		isScaleneTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());

	}

}
