package algorithum;

import util.ArrayUtils;
import util.TreeNode;;

/**
	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
	all the values along the path equals the given sum.
	
	Note: A leaf is a node with no children.
	
	Example:
	
	Given the below binary tree and sum = 22,
	
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \      \
	7    2      1
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	
 */
public class PathSum {
	
	
	public boolean hasPathSum(TreeNode root, int sum) {
		
		if(root == null)
			return false;
		if(root.left == null && root.right == null && sum-root.value == 0)
			return true;
		return hasPathSum(root.left, sum-root.value) || hasPathSum(root.right, sum-root.value);

	}
	
	public static void main(String[] args) {
		
		PathSum solution = new PathSum();
		
		Integer[] ary = {null, 5,4,8,11,null, 13,4,7,2, null, null, null, null, null, 1};
		
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		
		int[] sums = {22, 20, 26};
		
		for (int i : sums) {
			System.out.println("There "+(solution.hasPathSum(root, i)?"is":"isn't")+ " path sum as "+ i);
		}
	}
}
