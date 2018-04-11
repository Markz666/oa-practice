package oaPractice;
import java.util.*;
public class Pangram {
	public static String myPanagram(String s) {
		String str = s.toLowerCase().replaceAll(" ", "");
		Set<Character> lettersRemaining = new HashSet<>();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			lettersRemaining.add(ch);
		}
		for (int i = 0; i < str.length(); i++) {
			lettersRemaining.remove(str.charAt(i));
		}
		if (lettersRemaining.isEmpty()) {
			return "NULL";
		}
		String remain = "";
		for (char c : lettersRemaining) {
			remain += String.valueOf(c);
		}
		return remain;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test  = "abcdfghjiklmnopqtuvwxyz";
		System.out.println(myPanagram(test));
	}

}
