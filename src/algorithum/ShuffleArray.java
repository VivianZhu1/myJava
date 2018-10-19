package algorithum;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
	
	private int[] nums;
	private Random random;

	public ShuffleArray(int[] nums) {
	        this.nums = nums;
	        random = new Random();
	    }

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if (nums == null)
			return null;
		int[] a = nums.clone();
		for (int j = 1; j < a.length; j++) {
			int i = random.nextInt(j + 1);
			swap(a, i, j);
		}
		return a;
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		ShuffleArray solution = new ShuffleArray(array);
		
		for(int i = 0; i<5; i++) {
			System.out.println("Shuffer array "+i+" time:  "+Arrays.toString(solution.shuffle()));
		}
		
		
		
		
	}
}
