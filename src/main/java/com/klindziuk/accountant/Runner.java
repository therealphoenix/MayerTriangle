package com.klindziuk.accountant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
	
	
	public static void main(String[] args) throws IOException{
		
		Calculator calculator = new Calculator();
		List<Goods> listOfGoods = new ArrayList<>();
		String type = "";
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		while(true) 
		{
			System.out.print("Please input type of good or \"exit\" to quit: ");
			type = reader.readLine();
			
			if("exit".equals(type)){
				break;
			}
			System.out.print("Please input name of good: ");
			String name = reader.readLine();
			System.out.print("Please input quantity of good: ");
			int quantity = Integer.parseInt(reader.readLine());
			System.out.print("Please input price of good: ");
			double price = Double.parseDouble(reader.readLine());
			Goods good = new Goods(type,name,quantity,price);
			listOfGoods.add(good);
			System.out.println("Good " + name + " successfully added.");
		}
		
		scanner.close();
		calculator.setListOfGoods(listOfGoods);
		
			for(Goods g : calculator.getListOfGoods()){
				System.out.println(g);
			}
			
			calculator.getQuantityOfTypes(calculator.getListOfGoods());
			calculator.getQuantityOfAllGoods(calculator.getListOfGoods());
			calculator.getAveragepriceOfAllGoods(calculator.getListOfGoods());
			calculator.getAveragepriceForAnyType(calculator.getListOfGoods());
		}
		
		
	}


