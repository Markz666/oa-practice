package oaPractice;

import java.util.Arrays;

public class MaxSum {
	static long maxSum(int[][] matrix) {
		long res = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		// handle the single column case
		if (n == 1) {
			for (int i = 0; i < m; i++) {
				res += matrix[i][0];
			}
			return res;
		}

		long[] nums = new long[n];
		// convert 2D array into 1D array
		for (int i = 0; i < n; i++) {
			long num = 0;
			for (int j = 0; j < m; j++) {
				num += matrix[j][i];
			}
			// save the sum of the columns
			nums[i] = num;
		}

		Arrays.sort(nums);
		int index = 0;
		// count the number of columns that are smaller than 0
		while (index < n) {
			if (nums[index] > 0) {
				break;
			}
			index++;
		}
		if (index % 2 == 0) {
			for (long num : nums) {
				res += Math.abs(num);
			}
		} else {
			if (nums[index] < -nums[index - 1]) {
				nums[index] *= -1;
				nums[index - 1] *= -1;
			}
			for (int i = 0; i < index - 1; i++) {
				res += -nums[i];
			}
			for (int i = index - 1; i < n; i++) {
				res += nums[i];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] multi = new int[][]{
			  { 0, 1, 0, 0, 2, 0, 0, 0, 0, 0 },
			  { 0, -1, 0, 0, 4, 0, 0, 0, 0, 0 },
			  { 0, 2, 0, 0, 0, 0, 0, 0, 0, 0 },
			  { 0, 0, -2, 0, 0, 0, 0, 0, 0, 0 },
			  { 0, 0, -4, 0, 0, 0, 0, 0, 0, 0 }
		};
		System.out.println(maxSum(multi));
	}

}
