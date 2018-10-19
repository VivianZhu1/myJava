package algorithum;
import util.ArrayUtils;
import util.TreeNode;

/**
 * 
	    5
	   / \
	  1   4
	     / \
	    3   6
	Output: false
	
	Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
	             is 5 but its right child's value is 4.
 *
 *
		    2
		   / \
		  1   3
		  
	 Output: true
 */

public class ValidBinarySearchTree {
	

	
	public boolean isValidBSTRecursive(TreeNode root) {
		return _isValidBSTRecu(root, Long.MIN_VALUE, Long.MAX_VALUE);

	}
	
	private boolean _isValidBSTRecu(TreeNode root, long minValue, long maxValue) {
		if(root == null)
			return true;
		if(root.value <= minValue || root.value >= maxValue)
			return false;
		
		return _isValidBSTRecu(root.left, minValue, root.value) 
				&& _isValidBSTRecu(root.right, root.value, maxValue);
		
	}
	
	
	public static void main(String[] args) {
		
		ValidBinarySearchTree solution = new ValidBinarySearchTree();
		
		Integer[] ary = {null,5,1,4,null,null,3,6};
		TreeNode root1 = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		ArrayUtils.printOutTree(root1);
		System.out.println("Above tree "+(solution.isValidBSTRecursive(root1)?"IS ":"ISN'T ")+"valid BST.\n");
		
		Integer[] ary2 = {null,2,1,3};
		TreeNode root2 = ArrayUtils.makeBinaryTreeByArray(ary2, 1);
		ArrayUtils.printOutTree(root2);
		System.out.println("Above tree "+(solution.isValidBSTRecursive(root2)?"IS ":"ISN'T ")+"valid BST.");
	}
}
