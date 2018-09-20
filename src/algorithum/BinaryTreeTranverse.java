package algorithum;

import java.util.ArrayDeque;

import util.ArrayUtils;
import util.TreeNode;

public class BinaryTreeTranverse {
 

    TreeNode root;

    public BinaryTreeTranverse(int[] array){
        root=ArrayUtils.makeBinaryTreeByArray(array,1);
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }       
        ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        stack.push(root);       
        while(stack.isEmpty()==false){
            TreeNode node=stack.pop();
            System.out.print(node.value+"    ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }           
        }
        System.out.print("\n");
    }
    
    public void deptTransTree() {
    	
    	if(root == null) {
    		System.out.println("empty tree");
    		return;
    	}
    	ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
    	stack.push(root);
    	while(stack.isEmpty() == false ) {
    		TreeNode node = stack.pop();
    		System.out.print(node.value+"    ");
    		
    		if(node.right !=null) {
    			stack.push(node.right);
    		}
    		
    		if(node.left != null) {
    			stack.push(node.left);
    		}
    	}
    	
    }


    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.isEmpty()==false){
            TreeNode node=queue.remove();
            System.out.print(node.value+"    ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }
    
    public void levelTransTree() {
    	if(root == null) {
    		System.out.println("Empty tree!");
    		return;
    	}
    	ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();  
    	queue.add(root);
    	while(queue.isEmpty() == false) {
    		TreeNode node = queue.poll();
    		System.out.print(node.value+",   ");
    		if(node.left !=null) {
    			queue.offer(node.left);
    		}
    		if(node.right !=null ) {
    			queue.offer(node.right);
    		}
    	}
    }
    
    
    /** 
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
    public static void main(String[] args) {
        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTreeTranverse tree=new BinaryTreeTranverse(arr);
        tree.depthOrderTraversal();
//        tree.deptTransTree();
        tree.levelOrderTraversal();
//        tree.levelTransTree();
    }
}