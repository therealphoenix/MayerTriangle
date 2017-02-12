package com.klindziuk.network;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) { 
	    Scanner scanner = new Scanner(System.in); 
	 
	    System.out.println("Choose your destiny :D ? (S(erver) / C(lient))"); 
	    while (true) { 
	        char answer = Character.toLowerCase(scanner.nextLine().charAt(0)); 
	        if (answer == 's') { 
	            new Server(); 
	            break; 
	        } else if (answer == 'c') { 
	            new Client(); 
	            break; 
	        } else { 
	            System.out.println("Incorrect input.Please, try again"); 
	        } 
	    }
	    scanner.close();
	} 

}
