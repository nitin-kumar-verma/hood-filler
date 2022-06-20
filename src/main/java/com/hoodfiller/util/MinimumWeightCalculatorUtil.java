package com.hoodfiller.util;

import java.util.ArrayList;
import java.util.List;

public class MinimumWeightCalculatorUtil {
	public static List<Integer> getMinimumWeightArray(int totalWeight, List<Integer> weights) {
		int T[] = new int[totalWeight + 1];
		int R[] = new int[totalWeight + 1];
		T[0] = 0;
		for (int i = 1; i <= totalWeight; i++) {
			T[i] = Integer.MAX_VALUE - 1;
			R[i] = -1;
		}
		for (int j = 0; j < weights.size(); j++) {
			for (int i = 1; i <= totalWeight; i++) {
				if (i >= weights.get(j)) {
					if (T[i - weights.get(j)] + 1 < T[i]) {
						T[i] = 1 + T[i - weights.get(j)];
						R[i] = j;
					}
				}
			}
		}
		return getWeightArray(R, weights);
	}

	private static List<Integer> getWeightArray(int R[], List<Integer> weights) {
		List<Integer> weightArray = new ArrayList<>();
		if (R[R.length - 1] == -1) {
			return null;
		}
		int start = R.length - 1;
		while (start != 0) {
			int j = R[start];
			weightArray.add(weights.get(j));
			start = start - weights.get(j);
		}
		return weightArray;
	}
}
