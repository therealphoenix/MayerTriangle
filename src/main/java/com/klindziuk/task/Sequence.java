package com.klindziuk.task;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(99);

		System.out.println(decideSequence(list));

	}

	public static String decideSequence(List<Integer> list) {

		String result = "";

		for (int i = 0; i < list.size() - 1; i++) {

			if (list.get(i) > list.get(i + 1)) {

				result = "Sequence is  not growing";
				break;
			} else {

				result = "Sequence is  growing";
			}

		}

		return result;

	}
}
