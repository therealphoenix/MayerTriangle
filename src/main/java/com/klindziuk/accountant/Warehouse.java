package com.klindziuk.accountant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Warehouse {

	private List<Good> listOfGoods;

	public List<Good> getListOfGoods() {
		return listOfGoods;
	}

	public void addGoods(Good good) {
		this.listOfGoods.add(good);
	}

	public Warehouse() {
		this.listOfGoods = new ArrayList<>();
	}

	public int getQuantityOfTypes(List<Good> listOfGoods) {

		Set<String> setOfTypes = new HashSet<>();

		for (Good good : listOfGoods) {
			setOfTypes.add(good.getType());
		}
		return setOfTypes.size();
	}

	public int getQuantityOfAllGoods(List<Good> listOfGoods) {

		int result = 0;

		for (Good good : listOfGoods) {
			result = result + good.getQuantity();
		}
		return result;
	}

	public double getAveragepriceOfAllGoods(List<Good> listOfGoods) {

		double sumOfprice = 0;
		int quantityOfAllgoods = 0;
		
		if(0 == quantityOfAllgoods ) {
			return 0;
		}

		for (Good good : listOfGoods) {
			sumOfprice = sumOfprice + good.getPrice();
			quantityOfAllgoods = quantityOfAllgoods + good.getQuantity();
		}
		return (sumOfprice / quantityOfAllgoods);
	}

	public Map<String, Float> getAveragePriceForEachType(List<Good> listOfGoods) {

		Set<Good> setOfGoods = new HashSet<>();
		Map<String, Float> averagePriceMap = new HashMap<>();

		for (Good good : listOfGoods) {
			setOfGoods.add(good);
		}

		for (Good good : setOfGoods) {

			float sumOfPrice = 0;
			int quantityOfAllgoods = 0;

			for (Good g : listOfGoods) {

				if (good.getType().equals(g.getType())) {
					sumOfPrice = sumOfPrice + g.getPrice();
					quantityOfAllgoods = quantityOfAllgoods + g.getQuantity();
				}

			}

			averagePriceMap.put(good.getType(), (sumOfPrice / quantityOfAllgoods));
		}

		return averagePriceMap;
	}

}
