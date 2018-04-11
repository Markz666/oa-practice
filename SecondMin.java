package oaPractice;

public class SecondMin {
	public static int getSecondMin(int[] array) {
		if (array.length < 2) {
			return -1;
		}
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min1) {
				min2 = min1;
				min1 = array[i];
			} else if (array[i] < min2 && array[i] != min1) {
				min2 = array[i];
			}
		}
		if (min2 == Integer.MAX_VALUE) {
			return -1;
		}
		return min2;
	}
	
	public static int getSecondMax(int[] arr) {
		if (arr.length < 2) {
			return -1;
		}
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
			} else if (arr[i] > max2 && arr[i] != max1) {
				max2 = arr[i];
			}
		}
		if (max2 == Integer.MIN_VALUE) {
			return -1;
		}
		return max2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1,2,4,83,2451,24,-1};
		System.out.println(getSecondMin(array1));
		System.out.println(getSecondMax(array1));
	}
}
