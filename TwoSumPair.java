package oaPractice;

import java.util.*;

public class TwoSumPair {
	public static int getPairs(int[] arr, int k) {
		if (arr.length < 2 || arr == null) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int twice_count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.get(k - arr[i]) != null) {
				twice_count += map.get(k - arr[i]);
			}
			// take care of the cases like [1,1] and target = 2
			if (k - arr[i] == arr[i]) {
				twice_count--;
			}
		}
		return twice_count / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2, 4, 5, 6, 19, 20, 1, 3};
		System.out.println(getPairs(arr1, 6));
	}
}
