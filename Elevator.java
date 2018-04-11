package oaPractice;
import java.util.*;
public class Elevator {
	// A : weight of people, B: floors they need to get down, M:total floors in the building
	// X: max people to carry at a time, Y: max weight to carry at a time
	public static int getStops(int[] A, int[] B, int M, int X, int Y)
    {
        // initialize variables
        int totalStops = 0;
        long totalWeightPerRound = 0;
        int maxPersonsCount = 0;
        List<Integer> lstFloors = new ArrayList<Integer>();
        int currPerson = 0;
        boolean startLift = false;
        while (currPerson < A.length)
        {
            //Should current person be considered?
            if ((totalWeightPerRound + A[currPerson]) <= Y && (maxPersonsCount + 1) <= X) {
                totalWeightPerRound += A[currPerson];
                maxPersonsCount++;
                lstFloors.add(B[currPerson]);
                //If curr person is last person then start the lift
                if (currPerson == A.length - 1)
                    startLift = true;
                currPerson++;
            } else {
                startLift = true;
            }
            if (startLift) {
            	totalStops += lstFloors.size() + 1;
                //reset variable
                lstFloors.clear();
                maxPersonsCount = 0;
                totalWeightPerRound = 0;
                startLift = false;
            }
        }
        return totalStops;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {60, 80, 100, 90};
		int[] b = {3, 4, 5, 2};
		System.out.println(getStops(a, b, 8, 3, 200));
	}
}
