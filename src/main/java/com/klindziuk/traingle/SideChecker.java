package com.klindziuk.traingle;

public class SideChecker {
	
	
	public static boolean CheckSides(int sideA, int sideB, int sideC)  {
		
		if((sideA > 0) && (sideB > 0) && (sideC > 0) ){
			
			return true;
		}
			
		else
			
						
			return false;
				
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
