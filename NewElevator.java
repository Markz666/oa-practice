package oaPractice;
import java.util.*;
public class NewElevator {
    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || X < 1 || Y < 1) {
            return 0;
        }
        int res = 0;
        Queue<Task> taskQueue = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > Y) {
                throw new RuntimeException("This should not happen!");
            }
            taskQueue.add(new Task(A[i], B[i]));
        }
        while (!taskQueue.isEmpty()) {
            res += helper(taskQueue, M, X, Y);
        }
        return res;
    }
    /**
     * Process as much tasks as possible and then remove tasks from task queue.
     * <p>
     * Note: Here we use <code>bitmap</code> for enhance performance, while <code>set</code> is also an alternative.
     *
     * @param taskQueue task queue
     * @param M         floor range
     * @param X         max persons
     * @param Y         max weight
     *
     * @return stops
     */
    static int helper(Queue<Task> taskQueue, int M, int X, int Y) {
        BitSet floors = new BitSet(M);
        while (!taskQueue.isEmpty() && X > 0 && (Y - taskQueue.peek().weight) >= 0) {
            Task task = taskQueue.poll();
            X -= 1;
            Y -= task.weight;
            floors.set(task.floor);
        }
        return floors.cardinality() + 1;
    }
    /**
     * Task
     * <p>
     * For simplicity, here I do not let it be a POJO, just expose field publicly.
     */
    static class Task {
        int weight;
        int floor;

        public Task(int weight, int floor) {
            this.weight = weight;
            this.floor = floor;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {60, 80, 100, 90};
		int[] b = {3, 4, 5, 2};
		System.out.println(solution(a, b, 8, 3, 200));
	}
}
