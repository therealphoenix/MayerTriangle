package com.klindziuk.traingle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class Runner 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        
        Triangle triangle = new Triangle();
//        System.out.println(triangle.isCorrectScaleneTriangle(3, 4, 2));
//        System.out.println(triangle.isEqualSideTriangle(1, 1, 1));
//        System.out.println(triangle.isEqualHipTriangle(2, 3, 3));
//        System.out.println(triangle.isEqualHipTriangle(3, 2, 3));
//        System.out.println(triangle.isEqualHipTriangle(3, 3, 2));
        
     //  triangle.inputAndCheckSides();
     //  System.out.println(triangle.getSideA() + " " + triangle.getSideB() + " " + triangle.getSideC());
       triangle.decideTriangleType(triangle);
    	
       
    	
    }
}
