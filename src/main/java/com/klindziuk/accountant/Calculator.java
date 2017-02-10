package com.klindziuk.accountant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculator {

	private List<Good> listOfGoods;

	public List<Good> getListOfGoods() {
		return listOfGoods;
	}

	public void setListOfGoods(List<Good> listOfGoods) {
		this.listOfGoods = listOfGoods;
	}

	public void getQuantityOfTypes(List<Good> listOfGoods) {

		Set<String> setOfTypes = new HashSet<>();

		for (Good good : listOfGoods) {
			setOfTypes.add(good.getType());
		}

		System.out.println("Quantity of types is: " + setOfTypes.size());
	}

	public void getQuantityOfAllGoods(List<Good> listOfGoods) {

		int result = 0;

		for (Good good : listOfGoods) {
			result = result + good.getQuantity();
		}

		System.out.println("Quantity of all goods is: " + result);
	}

	public void getAveragepriceOfAllGoods(List<Good> listOfGoods) {

		double sumOfprice = 0;
		int quantityOfAllgoods = 0;

		for (Good good : listOfGoods) {
			sumOfprice = sumOfprice + good.getPrice();
			quantityOfAllgoods = quantityOfAllgoods + good.getQuantity();
		}
		

		System.out.println("Average price of all goods: " + (sumOfprice / quantityOfAllgoods));
	}

	public void getAveragepriceForAnyType(List<Good> listOfGoods) {
		
		Set<Good> setOfGoods = new HashSet<>();

		for (Good good : listOfGoods) {
			setOfGoods.add(good);
		}
		
		for(Good good : setOfGoods){
			
			double sumOfPrice = 0;
			int quantityOfAllgoods = 0;
			
			for(Good g : listOfGoods) {
				
				if(good.getType().equals(g.getType())){
					sumOfPrice = sumOfPrice + g.getPrice();
					quantityOfAllgoods = quantityOfAllgoods + g.getQuantity();
				}
				
			}
			
			System.out.println("Average price for " + good.getType() + ": " + (sumOfPrice / quantityOfAllgoods) );
		}

		

	}

}
