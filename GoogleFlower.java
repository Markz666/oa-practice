package oaPractice;

import java.util.TreeSet;

public class GoogleFlower {
	public static int kEmptySlots(int[] flowers, int k) {
		TreeSet<Integer> active = new TreeSet<>();
		int day = 0;
		for (int flower : flowers) {
			day++;
			active.add(flower);
			Integer lower = active.lower(flower);
			Integer higher = active.higher(flower);
			if (lower != null && flower - lower - 1 == k || higher != null && higher - flower - 1 == k) {
				return day;
			}
		}
		return -1;
	}
	
	private static int find(int[] arr, int p) {
        if (arr[p] < 0)
            return p;
        return arr[p] = find(arr, arr[p]);
    }
    private static boolean un(int[] arr, int p, int q, int k){
        p = find(arr, p);
        q = find(arr, q);
        boolean ans = false;
        if (arr[q] == -k)
            ans = true;
        if (arr[p] > arr[q]) {
        	// swap p and q
            p = p ^ q;
            q = p ^ q;
            p = p ^ q;
        }
        arr[p] += arr[q];
        arr[q] = p;
        return ans;
    }
    public static int flower2(int[] arr, int k) {
        int len = arr.length;
        if (len <= 2) return k;
        if (k == len)
            return len;
        int ans = -1;
        int[] unfd = new int[len + 2];
        for (int i = 0; i < len + 2; ++i)
            unfd[i] = 0;
        for (int i = 0; i < len; ++i) {
            int p = arr[i];
            unfd[p] = -1;
            if (unfd[p - 1] != 0){
                ans = un(unfd, p, p - 1, k) ? i : ans;
            }
            if (unfd[p + 1] != 0){
                ans = un(unfd, p, p + 1, k) ? i : ans;
            }
        }
        return ans;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] flowers = {3, 1, 5, 4, 2};
		System.out.println(kEmptySlots(flowers, 1));
		System.out.println(kEmptySlots(flowers, 2));
		System.out.println(flower2(flowers, 1));
		System.out.println(flower2(flowers, 2));
	}

}
