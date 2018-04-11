package oaPractice;
import java.util.*;
public class PrefixEvaluator {
	public static int prefixEvaluator(String str) {
		Stack<Character> operator = new Stack<>();
		for (char c : str.toCharArray()) {
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				operator.push(c);
			}
		}
		String numbersStr = str.replaceAll("[^0-9]", " ").replaceAll("\\s+", " ").trim();
		String[] numbersArr = numbersStr.split(" ");
		int[] numbers = new int[numbersArr.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numbersArr[i]);
		}
		if (numbers.length != operator.size() + 1) {
			throw new RuntimeException("Invalid input!");
		}
		double res = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			char op = operator.pop();
			switch (op) {
				case '+': res += numbers[i];
				break;
				case '-': res -= numbers[i];
				break;
				case '*': res *= numbers[i];
				break;
				case '/': res /= numbers[i];				
			}
		}		
		return (int) Math.round(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "*      +     /     2 3     5    6";
		String str2 = "* + 2 3 4 ";
		System.out.println(prefixEvaluator(str1));
		System.out.println(prefixEvaluator(str2));
	}

}
