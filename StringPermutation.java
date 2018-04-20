package indi.zmx.leetcode;
import java.util.*;
public class StringPermutation {
	public static List<String> strPermutation(String str) {
		List<List<String>> result = new ArrayList<>();
		List<String> tempList = new ArrayList<>();
		List<String> finalResult = new ArrayList<>();
		if (str == null || str.length() == 0) return finalResult;
		getPermutation(result, tempList, str);
		for (List<String> list : result) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
			}
			if (sb.length() == str.length()) {
				finalResult.add(sb.toString());
			}
		}
		return finalResult;
	}
	public static void getPermutation(List<List<String>> res, List<String> tempList, String str) {
		if (tempList.size() == str.length()) {
			res.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < str.length(); i++) {
				String temp = String.valueOf(str.charAt(i));
				if (tempList.contains(temp)) {
					continue;
				}
				tempList.add(temp);
				getPermutation(res, tempList, str);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		System.out.println(strPermutation(str));
	}
}
