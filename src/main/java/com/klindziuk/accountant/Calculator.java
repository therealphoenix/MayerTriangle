package com.klindziuk.accountant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculator {

	private List<Goods> listOfGoods;

	public List<Goods> getListOfGoods() {
		return listOfGoods;
	}

	public void setListOfGoods(List<Goods> listOfGoods) {
		this.listOfGoods = listOfGoods;
	}

	public void getQuantityOfTypes(List<Goods> listOfGoods) {

		Set<String> setOfTypes = new HashSet<>();

		for (Goods good : listOfGoods) {
			setOfTypes.add(good.getType());
		}

		System.out.println("Quantity of types is: " + setOfTypes.size());
	}

	public void getQuantityOfAllGoods(List<Goods> listOfGoods) {

		int result = 0;

		for (Goods good : listOfGoods) {
			result = result + good.getQuantity();
		}

		System.out.println("Quantity of all goods is: " + result);
	}

	public void getAveragepriceOfAllGoods(List<Goods> listOfGoods) {

		double sumOfprice = 0;
		int quantityOfAllgoods = 0;

		for (Goods good : listOfGoods) {
			sumOfprice = sumOfprice + good.getQuantity();
			quantityOfAllgoods = quantityOfAllgoods + good.getQuantity();
		}

		System.out.println("Average price of all goods: " + (sumOfprice / quantityOfAllgoods));
	}

	public void getAveragepriceForAnyType(List<Goods> listOfGoods) {
		
		Set<Goods> setOfGoods = new HashSet<>();

		for (Goods good : listOfGoods) {
			setOfGoods.add(good);
		}
		
		for(Goods good : setOfGoods){
			
			double sumOfPrice = 0;
			int quantityOfAllgoods = 0;
			
			for(Goods g : listOfGoods) {
				
				if(good.getType().equals(g.getType())){
					sumOfPrice = sumOfPrice + g.getPrice();
					quantityOfAllgoods = quantityOfAllgoods + g.getQuantity();
				}
				
			}
			
			System.out.println("Average price for " + good.getType() + ": " + (sumOfPrice / quantityOfAllgoods) );
		}

		

	}

}
