package algorithum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import util.ArrayUtils;
import util.TreeNode;

/**
	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

	Note: A leaf is a node with no children.
	
	Example:
	
	Given the below binary tree and sum = 22,
	
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \    / \
	7    2  5   1
	
	Return:
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
	
 */
public class PathSumII {
	
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		
		List<List<Integer>> result  = new LinkedList<List<Integer>>();
		
		List<Integer> currentResult  = new LinkedList<Integer>();
		
		pathSum(root,sum,currentResult,result);
		
		return result;
	}

	public void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {

		if (root == null)
			return;
		
		currentResult.add(root.value);
		
		// if arrive leaf node and find sum, then construct return list  by add that path into 'res'
		if (root.left == null && root.right == null && sum == root.value) {
			
			result.add(new LinkedList<Integer>(currentResult));
			
			//don't forget to remove the last integer
			currentResult.remove(currentResult.size() - 1);
			
			return;	
			
		} else { // if not leaf node, then dfs 
			pathSum(root.left, sum - root.value, currentResult, result);
			pathSum(root.right, sum - root.value, currentResult, result);
		}
		// remove every last node return to upper level
		currentResult.remove(currentResult.size() - 1);
	}
	
	public static void main(String[] args) {
		
		Integer[] ary = {null, 5,4,8,11,null,13,4,7,2,null, null, null,null, 5,1};
		
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		
		List<List<Integer>> list = new PathSumII().pathSum(root, 22);
		System.out.println("path sum value of 22 has path below:");
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
			
		}
	}

}
