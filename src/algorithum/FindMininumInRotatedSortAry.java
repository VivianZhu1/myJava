package algorithum;

import java.util.Arrays;

/**
 
	 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	
	(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
	
	Find the minimum element.
	
	You may assume no duplicate exists in the array.
	
	Example 1:
	
	Input: [3,4,5,1,2] 
	Output: 1
	
	Example 2:
	
	Input: [4,5,6,7,0,1,2]
	Output: 0
	
 */
public class FindMininumInRotatedSortAry {
	
	public int findMin1(int[] nums) {
		
		// If the list has just one element then return that element.
		if (nums.length == 1) {
			return nums[0];
		}

		// initializing left and right pointers.
		int left = 0, right = nums.length - 1;

		// if the last element is greater than the first element then there is no
		// rotation.
		// e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
		// Hence the smallest element is first element. A[0]
		if (nums[right] > nums[0]) {
			return nums[0];
		}

		// Binary search way
		while (right >= left) {
			// Find the mid element
			int mid = left + (right - left) / 2;

			// if the mid element is greater than its next element then mid+1 element is the
			// smallest
			// This point would be the point of change. From higher to lower value.
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}

			// if the mid element is lesser than its previous element then mid element is
			// the smallest
			if (nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}

			// if the mid elements value is greater than the 0th element this means
			// the least value is still somewhere to the right as we are still dealing with
			// elements
			// greater than nums[0]
			if (nums[mid] > nums[0]) {
				left = mid + 1;
			} else {
				// if nums[0] is greater than the mid value then this means the smallest value
				// is somewhere to
				// the left
				right = mid - 1;
			}
		}
		return -1;
	}
	
	/**
	 * because this is a sorted array, so we can use binary search
	 * 
	 * @param num
	 * @return
	 */
	public int findMin(int[] num) {
		int low = 0;
		int high = num.length - 1;
		while (low < high) {
			// to avoid Integer overflow
			int mid = low + (high - low) / 2;
			
			// if mid > high, the min is in the right part(rotated part). 
			//then low = mid+1
			if (num[high] < num[mid]) {
				low = mid + 1;
			} else {
				// not in the rotated part,mid< high
				high = mid;
			}
		}
		// the array is ascend sorted. 
		return num[low];
	}

	public static void main(String[] args) {
		
		FindMininumInRotatedSortAry solution = new FindMininumInRotatedSortAry();
		
		
		int[][] arrays = {{3,4,5,1,2},
						  {4,5,6,7,0,1,2},
						  {3,5,6,7,8,2},
						  {2,2,2,2}};
		
		for (int[] ary : arrays) {
			System.out.println("Mininum of array "+ Arrays.toString(ary)+" is: "+solution.findMin(ary) );
		}
	}
}
