package oaPractice;

import java.util.*;

public class AlternativeNumber {
	public static int[] alternativeNum(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		boolean flag = true;
		int count = 0;
		int[] res = new int[(nums.length + 1) / 2];
		for (int num : nums) {
			stack.push(num);
		}
		while (!stack.isEmpty()) {
			if (flag) {
				res[count] = stack.pop();
				count++;
			} else {
				stack.pop();
			}		
			flag = !flag;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] res = alternativeNum(arr);
		for (int a : res) {
			System.out.print(a + " ");
		}
	}
}
