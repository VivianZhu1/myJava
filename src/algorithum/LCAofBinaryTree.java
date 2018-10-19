package algorithum;
import util.ArrayUtils;
import util.TreeNode;;



/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
  		 _____3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_      0       8
         /   \
        7     4
         
 *
 *
 */
public class LCAofBinaryTree {
	
	public static void main(String[] args) {
	
		Integer[] ary = {null,3,5,1,6,2,0,8,null, null, 7,4};
		
		TreeNode root = ArrayUtils.makeBinaryTreeByArray(ary, 1);
		
		ArrayUtils.printOutTree(root, "Create tree as:");
		
		TreeNode lcaNode = lowestCommonAncestor(root, new TreeNode(0) , new TreeNode(4));
		System.out.println( "LCA of [0,4] is : "+(lcaNode==null?"null": lcaNode.value));
		
		TreeNode lcaNode1 = lowestCommonAncestor(root, new TreeNode(7) , new TreeNode(4));
		System.out.println( "LCA of [7,4] is : "+(lcaNode1==null?"null": lcaNode1.value));
		
		TreeNode lcaNode2 = lowestCommonAncestor(root, new TreeNode(7) , new TreeNode(9));
		System.out.println( "LCA of [7,9] is : "+(lcaNode2==null?"null": lcaNode2.value));
		
		TreeNode lcaNode3 = lowestCommonAncestor(root, new TreeNode(6) , new TreeNode(9));
		System.out.println( "LCA of [6,9] is : "+(lcaNode3==null?"null": lcaNode3.value));
		
		TreeNode lcaNode4 = lowestCommonAncestor(root, new TreeNode(15) , new TreeNode(20));
		System.out.println( "LCA of [15,20] is : "+(lcaNode4==null?"null": lcaNode4.value));
	}
	
	/**
	 * 
	 * if both p and q exist in Tree rooted at root, then return their LCA
	 * if neither p and q exist in Tree rooted at root, then return null 
	 * if only one of p or q (NOT both of them), exists in Tree rooted at root, return it
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return  
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		//only one of p or q (NOT both of them), exists in Tree rooted at root
		if(root== null || root.value == p.value || root.value == q.value)
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		//oth p and q exist in Tree rooted at root
		if(left!=null &&right !=null )
			return root;
		
		//neither p and q exist in Tree rooted at root
		return left!=null?left:right;
	      
	        
	}
}
