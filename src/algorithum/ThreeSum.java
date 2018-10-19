package algorithum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.
	
	Note:
	
	The solution set must not contain duplicate triplets.
	
	Example:
	
	Given array nums = [-1, 0, 1, 2, -1, -4],
	
	A solution set is:
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
 */
public class ThreeSum {

	
	/**
	 * 将原数组存放中ArrayList中，通过判断 -(nums[i]+nums[j]) 是否在ArrayList中，少了第三个for循环，
	 * 时间复杂度O(N2)增加了空间发杂度O(N)
	 * @param numbers
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		// write your code here
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numbers == null || numbers.length < 3)
			return result;
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++)
			nums.add(numbers[i]);
		
		for (int i = 0; i < nums.size() - 2; i++) {
			for (int j = i + 1; j < nums.size() - 1; j++) {
				int sum = -((Integer) nums.get(i) + (Integer) nums.get(j));
				if (nums.contains(sum) && nums.indexOf(sum) != j && nums.indexOf(sum) != i) {
					path = sort3(sum, nums.get(i), nums.get(j));
					if (result.contains(path) == false)
						result.add(path);
				}
			}
		}
		return result;
	}

	public ArrayList<Integer> sort3(int a, int b, int c) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		if (c <= a) {
			path.add(c);
			path.add(a);
			path.add(b);
		} else if (c >= b) {
			path.add(a);
			path.add(b);
			path.add(c);
		} else {
			path.add(a);
			path.add(c);
			path.add(b);
		}
		return path;

	}
	
	/**
	 * 直接暴力，时间复杂度是O(N3)
	 * @param numbers
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum2(int[] numbers) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numbers == null || numbers.length < 3)
			return result;
		for (int i = 0; i < numbers.length - 2; i++) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			for (int j = i + 1; j < numbers.length - 1; j++) {
				for (int k = j + 1; k < numbers.length; k++)
					if (numbers[i] + numbers[j] + numbers[k] == 0) {
						path = sort3(numbers[i], numbers[j], numbers[k]);
						if (result.contains(path) == false)
							result.add(path);
					}
			}
		}
		return result;
	}
	
	/**
	 * 三个数的和基础还是两个数的和、两个数的和II，a+b+c = 0，等价于a+b = -c,这样就和两个数的和II 很类似，当然也可以参考两个数的和I求解。
	 * 先对数组排序，排序后的数组，定义其实节点i，然后对i+1 到len内的所有节点进行两端遍历，这里利用二分查找的思想，
	 * 设两端的两个下标是left 和right ，显然 sum=nums[i] + nums[left] + nums[right] >0时候 ，right--,小于0的时候left++,
	 * 等于0的时候就是答案。时间复杂度O(NlogN)
	 * 
	 * @param numbers
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum3(int[] numbers) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if (numbers == null || numbers.length < 3)
			return result;
		
		Arrays.sort(numbers);
		
		for (int i = 0; i < numbers.length; i++) {
			int left = i + 1;
			int right = numbers.length - 1;
			while (left < right) {
				int sum = numbers[i] + numbers[left] + numbers[right];
				ArrayList<Integer> path = new ArrayList<Integer>();
				if (sum == 0) {
					path.add(numbers[i]);
					path.add(numbers[left]);
					path.add(numbers[right]);
					if (result.contains(path) == false)
						result.add(path);
					left++;
					right--;
				} else if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		ThreeSum solution = new ThreeSum();
		
		int[] nums = {-1, 0, 1, 2, -1, -4};
		
		List<ArrayList<Integer>> lists = solution.threeSum2(nums);
		System.out.println("Brutal force O(n^3):  "+lists.toString());
		
		List<ArrayList<Integer>> list2 = solution.threeSum(nums);
		System.out.println("Leverage diff O(n^2):  "+list2.toString());
		
		List<ArrayList<Integer>> list3 = solution.threeSum3(nums);
		System.out.println("Binary search O(NlogN):  "+list3.toString());
	}
}
