package oaPractice;

public class ClimbStairs {
	public static int climbStairs(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		for (int i = 0; i < n + 1; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i >= j) {
					f[i] += f[i - j];
				}
			}
		}
		return f[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(4));
	}
}
