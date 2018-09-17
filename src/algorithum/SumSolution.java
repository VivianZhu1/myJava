package algorithum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumSolution {
	
	public static void main(String[] args) {
		
		int[] ary = {2,5,5,11};
		int target = 10;
		
		int[] rs = SumSolution.twoSum(ary, target);
		System.out.println(Arrays.toString(rs));
		
		
	}

	/**
	 * 
	 * Given an array of integers, return indices of the two numbers such that they add up to a
	 *  specific target.You may assume that each input would have exactly one solution, 
	 *  and you may not use the same element twice.
	 * 
	 * @param ary
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] ary, int target) {
		int[] rs = new int[2];
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < ary.length; i++) {
			numMap.put(ary[i], i);
		}
		
		for(int j = 0; j<ary.length; j++) {
			 int complement = target - ary[j];
		        if (numMap.containsKey(complement) && numMap.get(complement) != j) {
		            return new int[] { j, numMap.get(complement) };
		        }
		}
		
		return rs;
	}
}
