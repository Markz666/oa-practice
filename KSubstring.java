package oaPractice;
import java.util.*;
public class KSubstring {
	public static String[] ksubstring(String s, int k) {
		char[] nums = s.toCharArray();
		Set<String> hash = new HashSet<>();
		String res = "";
		for (int i = 0; i < nums.length - k + 1; i++) {
			for (int j = 0; j < k; j++) {
				if (i + j < nums.length) {
					res = res + nums[i + j];
				}
			}
			hash.add(res);
			res = "";
		}
		String[] strArr = hash.toArray(new String[hash.size()]);
		return strArr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "caaab";
//		System.out.println(ksubstring(s, 2));
		String[] strArr = ksubstring(s, 2);
		Object[] objArr = {strArr}; // Array of String Arrays
		for (Object obj : objArr) {
		    if (obj instanceof String[]) {
		        String[] strArray = (String[]) obj;
		        System.out.println(Arrays.toString(strArray));
		    }
		}
	}
}
