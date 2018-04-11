package oaPractice;

public class NextClosestTime {
	public String nextClosestTime(String S) {
        int currTime = StringToDate(S);
        char[] charTmp = new char[] {'0', '0', '0', '0'};
        int originalSum = S.charAt(0) + S.charAt(1) + S.charAt(3) + S.charAt(4);
        int j = 0;
        for (int i = 1; i <= 1440; ++i) {
            int nextTime = (currTime + i) % 1440;
            int total = 0;
            for (j = 0; j < 4; ++j) {
                charTmp[j] = String.valueOf(getDigitNum(nextTime, j)).charAt(0);
                nextTime = removeDigitNum(nextTime, j);
                // if digits didn't match, break;
                if (S.indexOf(charTmp[j] + "") == -1) {
                    break;    
                } else {
                	total += charTmp[j];
                }
            }
            // found the answer, break
            if (j >= 4 && originalSum == total) 
            	break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charTmp[0]).append(charTmp[1]).append(":").append(charTmp[2]).append(charTmp[3]);
        return sb.toString();
    }
	public int removeDigitNum(int time, int digit) {
        int[] digits = new int[] {600, 60, 10, 1};
        return time % digits[digit];
    }
    
    public int getDigitNum(int time, int digit) {
        int[] digits = new int[] {600, 60, 10, 1};
        return time / digits[digit];
    }
    
    public int StringToDate(String S) {
        String num[] = S.split(":"); 
        int curr = Integer.parseInt(num[0]) * 60 + Integer.parseInt(num[1]);
        return curr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "03:29";
		NextClosestTime sample = new NextClosestTime();
		System.out.println(sample.nextClosestTime(s));

	}

}
