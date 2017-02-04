package com.klindziuk.traingle;

public class MayersTriangle {

	private static MayersTriangle mayersTriangle;

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

	private MayersTriangle(int sideA, int sideB, int sideC) {
		this.sideA = sideA;
		this.sideA = sideB;
		this.sideA = sideC;
	}

	public static void init(int sideA, int sideB, int sideC) throws IllegalArgumentException {
		
		mayersTriangle = null;
		
		if((SideChecker.CheckSides(sideA, sideB, sideC) && SideChecker.checkSumOfSides(sideA, sideB, sideC))) {
			System.out.println("Sides are correct, we can create triangle.");
				mayersTriangle = new MayersTriangle(sideA, sideB, sideC);
		}
				else throw new IllegalArgumentException();
		}
		
	public static MayersTriangle getInstance() {
		
		return mayersTriangle;
	}

	public boolean isScalene(int sideA, int sideB, int sideC) {

		if (((sideA + sideB) > sideC) && ((sideB + sideC) > sideA) && ((sideA + sideC) > sideB) && (sideA != sideB)
				&& (sideA != sideC) && (sideB != sideC))

		{

			System.out.println("Triangle is Scalene and correct.");
			return true;
			
		} else

		{
			return false;
	}
		
	}
	public boolean isEquilateral(int sideA, int sideB, int sideC) {

		if ((sideA == sideB) && (sideA == sideC) && (sideB == sideC)) {

			System.out.println("Triangle is Equilateral and correct.");
			return true;
			
		} else
			
			return false;
	}

	public boolean isIsosceles(int sideA, int sideB, int sideC) {

		if ((sideA == sideB) || (sideB == sideC) || (sideA == sideC)) {

			System.out.println("Triangle is Isosceles and correct.");
			return true;
		}

		else
			
		{
			return false;
	}
		
	}

	public void decideTriangleType(MayersTriangle triangle) {

		isIsosceles(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
		isEquilateral(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
		isScalene(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());

	}

}
