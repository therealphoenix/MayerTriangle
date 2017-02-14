package com.klindziuk.accountant;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Printer {
	
	void printListOfAllgoods(List<Good> warehouseList) {
		if( 0 == warehouseList.size() ) {
			System.out.println("\nWarehouse is empty.");
		}
		
		else {
		
		for (Good g : warehouseList) {
			System.out.println(g);
		}
		System.out.println();
		}
	}
	
	
	void printQuantityOfTypes(int quantityOFTypes){
		
	if( 0 == quantityOFTypes ) {
		System.out.println("\nWarehouse is empty.");
	}
	
	else {
	System.out.println("\nQuantity of types is: " + quantityOFTypes);
	System.out.println();
	}
	
	}
	void printQuantityOFAllGoods(int quantityOfAllGoods) {
		
		if( 0 == quantityOfAllGoods ) {
			System.out.println("\nWarehouse is empty.");
		}
		
		else {
		
		System.out.println("\nQuantity of all goods is: " + quantityOfAllGoods);
		
			}
	}
	
	void printAveragePriceOfAllGoods(double averagePriceOfAllGoods)
	{
		if( 0 == averagePriceOfAllGoods ) {
			System.out.println("\nWarehouse is empty.");
		}
		
		else {
		
		System.out.println("\nAverage price of all goods: " + averagePriceOfAllGoods);
	}
	
	}
	void printAveragePriceForEachType( Map<String, Float> averagePriceMap) {
		
		if( 0 == averagePriceMap.size() ) {
			System.out.println("\nWarehouse is empty.");
		}
		
		else {
		
		
		for(Entry<String, Float> entry : averagePriceMap.entrySet()){
			
			System.out.print("\nAverage price for " + entry.getKey() + ": " + entry.getValue());
		}
	}
		System.out.println();
	 
	}
}
