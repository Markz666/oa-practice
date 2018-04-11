package oaPractice;

public class FindUniqueChar {
	public static String findUnique(String str) {
		int[] freq = new int[26];
		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i) - 'a']++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (freq[str.charAt(i) - 'a'] == 1) {
				return String.valueOf(str.charAt(i));
			}
		}
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "loveleetcode";
		System.out.println(findUnique(a));
	}

}
