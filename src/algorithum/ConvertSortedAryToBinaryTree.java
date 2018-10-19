package algorithum;

import util.ArrayUtils;
import util.TreeNode;

/**
	 Given the sorted array: [-10,-3,0,5,9],
	
	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
	
	      0
	     / \
	   -10  5
	     \   \
	     -3   9
 */
public class ConvertSortedAryToBinaryTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		
		if(nums == null || nums.length ==0)
			return null;
		
		return buildTree(nums, 0, nums.length-1);
	}

	public TreeNode buildTree(int nums[], int low, int high) {
		if (low > high)
			return null;

		int mid = (low + high) / 2;
		
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, low, mid-1);
		root.right = buildTree(nums, mid + 1, high);
		return root;
	}
	
	public static void main(String[] args) {
		
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = new ConvertSortedAryToBinaryTree().sortedArrayToBST(nums);
		ArrayUtils.printOutTree(root);
	}
}
