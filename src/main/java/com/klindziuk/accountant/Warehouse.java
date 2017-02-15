package com.klindziuk.accountant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Warehouse {

	private List<Good> listOfGoods;
	private Set<String> setOfTypes;
	private Set<String> setOfNames;

	public Warehouse() {
		this.listOfGoods = new ArrayList<>();
		this.setOfTypes = new HashSet<>();
		this.setOfNames = new HashSet<>();
	}

	public int getQuantityOfTypes() {
		return this.setOfTypes.size();
	}

	public int getQuantityOfAllGoods() {

		int result = 0;

		for (Good good : this.listOfGoods) {
			result = result + good.getQuantity();
		}
		return result;
	}

	public String getAveragePriceOfGood(String nameOfGood) {
		String result = null;

		if (this.setOfNames.size() == 0) {

			return null;
		}

		Map<String, Float> averagePriceoFGoodMap = new HashMap<>();

		for (String name : this.setOfNames) {

			float sumOfPrice = 0;
			int quantityOfAllgoods = 0;

			for (Good good : this.listOfGoods) {

				if (name.equals(good.getName())) {
					sumOfPrice = sumOfPrice + good.getPrice();
					quantityOfAllgoods = quantityOfAllgoods + good.getQuantity();
				}

			}
			averagePriceoFGoodMap.put(name, (sumOfPrice / quantityOfAllgoods));

		}

		for (Entry<String, Float> entry : averagePriceoFGoodMap.entrySet()) {

			if (entry.getKey().equals(nameOfGood)) {

				result = entry.getKey() + ": " + entry.getValue();

			}

		}

		return result;

	}

	public Map<String, Float> getAveragePriceForEachType() {

		if (this.setOfTypes.size() == 0) {

			return null;
		}

		Map<String, Float> averagePriceMap = new HashMap<>();

		for (String type : this.setOfTypes) {

			float sumOfPrice = 0;
			int quantityOfAllgoods = 0;

			for (Good good : this.listOfGoods) {

				if (type.equals(good.getType())) {
					sumOfPrice = sumOfPrice + good.getPrice();
					quantityOfAllgoods = quantityOfAllgoods + good.getQuantity();
				}

			}

			averagePriceMap.put(type, (sumOfPrice / quantityOfAllgoods));
		}

		return averagePriceMap;
	}

	public List<Good> getListOfGoods() {
		return listOfGoods;
	}

	public void addGood(Good good) {
		this.listOfGoods.add(good);
		this.setOfTypes.add(good.getType());
		this.setOfNames.add(good.getName());
	}

}
