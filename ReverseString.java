package oaPractice;

public class ReverseString {
    public static String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0, j = word.length - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(word);
    }
     
    public static String trueReverse(String s) {
    	String[] words = s.split(" ");
    	String reverseStr = "";
    	for (int i = 0; i < words.length; i++) {
    		String word = words[i];
    		String reverseWord = "";
    		for (int j = word.length() - 1; j >= 0; j--) {
    			reverseWord += word.charAt(j);
    		}
    		reverseStr += reverseWord + " ";
    	}
    	return reverseStr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello World!";
		System.out.println(reverseString(s1));
		System.out.println(trueReverse(s1));
	}
}
