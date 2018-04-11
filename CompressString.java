package oaPractice;

public class CompressString {
	public static String compressStr(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		if (str.length() == 2) {
			if (str.charAt(0) == str.charAt(1)) {
				return str.charAt(0) + "2";
			} else {
				return str;
			}
		}
		for (int i = 0; i < str.length(); i++){
			int j = i + 1;
			while (j < str.length() && str.charAt(j) == str.charAt(i)){
				j++;
			}
			if (j - i != 1) {
				str = str.substring(0, i + 1) + (j - i) + str.substring(j);
				i++;
			}
		}
		return str;
	}
	public static String strCompress(String str) {
		char[] arr = str.toCharArray();
		int count = 1;
		StringBuilder sb = new StringBuilder();
		char prev = arr[0];
		for (int i = 1; i < arr.length; i++) {
			char curr = arr[i];
			prev = arr[i - 1];
			if (curr == prev) {
				count++;
			} else {
				if (count < 2) {
					sb.append(prev);
				} else {
					sb.append(count).append(prev);
					count = 1;
				}
			}
		}
		if (count < 2) {
			sb.append(prev);
		} else {
			sb.append(count).append(prev);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "aaabbbbcccccaaaa";
		System.out.println(compressStr(str1));
		System.out.println(strCompress(str1));
	}
}
