package algorithum;

import util.ArrayUtils;
import util.TreeNode;

/**
	Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
	where largest means subtree with largest number of nodes in it.
	
	Note:
	A subtree must include all of its descendants.
	Here's an example:
	    10
	    / \
	   5  15
	  / \   \ 
	 1   8   7
	
	The Largest BST Subtree in this case is the [5,1,8]. The return value is the subtree's size, which is 3.

 *
 */
public class LargestBSTSubtree {
	private int max = 0;

	/**
	 * 
	 * 方法：递归检查。一颗子树当且仅当其左右子树都是BST，并且左子树的最大值小于根节点，右子树的最小值大于根节点的时候，
	 * 这棵子树才是BST。则定一个递归函数的返回结果，包括该节点能否形成一棵BST，以及该BST的节点总数。
	 * 
	 * 	    10
		    / \
		   5  15
		  / \   \ 
		 1   8   7
		 
	 * @param root
	 * @return int
	 */
	private Range check(TreeNode root) {
		Range range = new Range(root.value, root.value);
		Range left = (root.left == null) ? null : check(root.left);
		Range right = (root.right == null) ? null : check(root.right);
		if (left != null) {
			if (!left.bst || left.max >= root.value)
				return range;
			range.min = left.min;
			range.count += left.count;
		}
		if (right != null) {
			if (!right.bst || root.value >= right.min)
				return range;
			range.max = right.max;
			range.count += right.count;
		}
		range.bst = true;
		max = Math.max(max, range.count);
		return range;
	}

	public int largestBSTSubtree(TreeNode root) {
		if (root != null)
			check(root);
		return max;
	}
	
	public static void main(String[] args) {
		
		LargestBSTSubtree solution = new LargestBSTSubtree();
		
		Integer[] ary = {null, 10,5,15,1,8,null,7};
		
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		
		int rs = solution.largestBSTSubtree(root);
		
		System.out.println("Largest BST subtree node count:"+ rs);
		
		
	}
}

class Range {
	boolean bst;
	int min, max;
	int count = 1;

	Range(int min, int max) {
		this.min = min;
		this.max = max;
	}

}
