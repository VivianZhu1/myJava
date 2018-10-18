package algorithum;

import java.util.Arrays;

/**
 *
	Given an array, rotate the array to the right by k steps, where k is non-negative.
	
	Example:
	
	Input: [1,2,3,4,5,6,7] and k = 3
	Output: [5,6,7,1,2,3,4]
	Explanation:
	rotate 1 steps to the right: [7,1,2,3,4,5,6]
	rotate 2 steps to the right: [6,7,1,2,3,4,5]
	rotate 3 steps to the right: [5,6,7,1,2,3,4]
	
 */
public class RotateArray {

	public void rotate(int[] nums, int k) {
		
		if(nums == null || k == 0)
			return ;
		
		while(k-- > 0) {
			int temp = nums[nums.length-1];
			for(int i = nums.length-2; i>=0; i--) {
				nums[i+1] =nums[i];
			}
			nums[0] = temp;
		}

	}
	
	public static void main(String[] args) {
		
		int[] ary = {1,2,3,4,5,6,7};
		new RotateArray().rotate(ary, 3);
		System.out.println(Arrays.toString(ary));
		
	}

}
