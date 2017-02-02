package com.klindziuk.traingle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner 
{
    public static void main( String[] args ) 
    {
        
       Triangle triangle = new Triangle(inputSides());
       triangle.decideTriangleType(triangle);
    	
       
    }
    
    public static int[] inputSides(){
		
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
  			
  			arrayOfsides[0] = a;
  			arrayOfsides[1] = b;
  			arrayOfsides[2] = c;
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
  	
}
