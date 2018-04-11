package oaPractice;

import java.util.*;


public class Josephus {
    public static int execute(int n, int k){
        int killIdx = 0;
        ArrayList<Integer> prisoners = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            prisoners.add(i);
        }
        System.out.println("Prisoners executed in order:");
        while (prisoners.size() > 1) {
            killIdx = (killIdx + k - 1) % prisoners.size();
            System.out.print(prisoners.get(killIdx) + " ");
            prisoners.remove(killIdx);
        }
        System.out.println();
        return prisoners.get(0);
    }
    
    public static int[] myJosephus(int n, int k) {
    	int killIndex = 0;
    	int[] res = new int[n];
    	ArrayList<Integer> list = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
    		list.add(i);
    	}
    	for (int i = list.size() - 1; i >= 0; i--) {
    		killIndex = (killIndex + k - 1) % list.size();
    		res[n - i - 1] = list.get(killIndex);
    		list.remove(killIndex);
    	}
    	
//    	for (int i = list.size() - 1; i >= 0; i--) {
//		killIndex = (killIndex + k - 1) % list.size();
//		res[i] = list.get(killIndex);
//		list.remove(killIndex);
//	}
    	
//    	for (int i = 0; i < res.length / 2; i++) {
//    		  int temp = res[i];
//    		  res[i] = res[res.length - 1 - i];
//    		  res[res.length - 1 - i] = temp;
//    	}
    	return res;
    }
 
    public static ArrayList<Integer> executeAllButM(int n, int k, int m) {
        int killIdx = 0;
        ArrayList<Integer> prisoners = new ArrayList<Integer>(n);
        for(int i = 0; i < n; i++) {
            prisoners.add(i);
        }
        System.out.println("Prisoners executed in order:");
        while (prisoners.size() > m) {
            killIdx = (killIdx + k - 1) % prisoners.size();
            System.out.print(prisoners.get(killIdx) + " ");
            prisoners.remove(killIdx);
        }
        System.out.println();
        return prisoners;
    }
    
    public static int josephus(int n, int k) {
    	if (n == 1) {
    		return 1;
    	} else {
    		return (josephus(n - 1, k) + k - 1) % n + 1;
    	}
    }
    
    public static int[] josephusSimulation(int total, int k) {
    	int[] arr = new int[total];
    	int[] res = new int[total];
    	int count = 0, index = 0;
    	while (count < total) {
    		for (int i = 0; i < arr.length; i++) {
    			if (arr[i] == 0) {
    				index++;
    			}
    			if (index == k) {
    				arr[i] = -1;
    				index = 0;
    				res[count] = i;
    				count++;
    			}
    		}
    	}
    	return res;
    }
 
    public static void main(String[] args){
//        System.out.println("Survivor: " + execute(10, 3));
//        System.out.println("Survivors: " + executeAllButM(41, 3, 3));
//        System.out.println("Survivors: " + josephus(10, 3));
        int[] resArr = josephusSimulation(10, 3);
        for (int e : resArr) {
        	System.out.print(e + " ");
        }
        System.out.println();
        int[] myArr = myJosephus(10, 3);
        for (int a : myArr) {
        	System.out.print(a + " ");
        }
    }
}