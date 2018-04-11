package oaPractice;

import java.util.*;

public class SortByLastThreeDigits {
	public static int sortByLastThreeDigits(int[] nums, int position) {
		int smallCnt = 0, largeCnt = 0, sc = 0, lc = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 1000) {
				sc++;
			} else {
				lc++;
			}
		}
		int[] smallArr = new int[sc];
		int[] largeArr = new int[lc];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 1000) {
				smallArr[smallCnt++] = nums[i]; 
			} else {
				largeArr[largeCnt++] = nums[i];
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < largeCnt; i++) {
			int temp = largeArr[i] % 1000;
			map.put(temp, largeArr[i]);
			largeArr[i] = temp;
		}
		Arrays.sort(smallArr);
		Arrays.sort(largeArr);
		for (int i = 0; i < largeArr.length; i++) {
			largeArr[i] = map.get(largeArr[i]);
		}
		int[] res = new int[nums.length];
		System.arraycopy(smallArr, 0, res, 0, smallCnt);
		System.arraycopy(largeArr, 0, res, smallCnt, largeCnt);
		return res[position - 1];
	}
	
	public static int sort2(Integer[] nums, int pos) {
		Arrays.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if (a > 1000 && b > 1000) {
					return a % 1000 - b % 1000;
				} else {
					return a - b;
				}
			}
		});
		return nums[pos - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArr = new int[] {5, 3, 7, 5821, 17523, 15352, 420};
		Integer[] newArr = new Integer[] {5, 3, 7, 5821, 17523, 15352, 420};
		System.out.println(sortByLastThreeDigits(testArr, 5));
		System.out.println(sort2(newArr, 5));
	}
}
