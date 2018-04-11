package oaPractice;
import java.util.*;
public class MaxAverage {
	public static int getMax(String[][] info) {
		Map<String, Double> map = new HashMap<>();
		Map<String, Integer> count = new HashMap<>();
		Map<String, Double> average = new HashMap<>();
		for (int i = 0; i < info.length; i++) {
			if (!map.containsKey(info[i][0])) {
				map.put(info[i][0], Double.valueOf(info[i][1]));
				count.put(info[i][0], 1);
				average.put(info[i][0], Double.valueOf(info[i][1]));
			} else {
				map.put(info[i][0], map.get(info[i][0]) + Double.valueOf(info[i][1]));
				count.put(info[i][0], count.get(info[i][0]) + 1);
				average.put(info[i][0], map.get(info[i][0]) / count.get(info[i][0]));
			}
		}
		double max = (Collections.max(average.values()));
		return (int)Math.floor(max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] grades = {{"Bob", "-88"}, {"Ted", "-100"}, {"Ted", "20"}, {"Tom", "-12"}, {"Tom", "-29"}};
		System.out.println(getMax(grades));
	}
}
