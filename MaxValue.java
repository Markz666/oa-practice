package oaPractice;

import java.util.Scanner;

public class MaxValue {
	
	public static int getMaxValue(int m, int[] A) {
		boolean[][] f = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= A[i - 1] && f[i - 1][j - A[i - 1]]) {
                    f[i][j] = true;
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String totalStr = sc.nextLine();
		int total = Integer.valueOf(totalStr);
		String s = sc.nextLine();
		String[] pricesStr = s.split(" ");
		int[] prices = new int[pricesStr.length];
		for (int i = 0; i < pricesStr.length; i++) {
			prices[i] = Integer.parseInt(pricesStr[i]);
		}
		sc.close();
		System.out.println(getMaxValue(total, prices));
	}
}
