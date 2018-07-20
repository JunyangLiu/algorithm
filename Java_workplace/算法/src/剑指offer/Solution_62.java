package 剑指offer;

import java.util.Stack;

import tree.TreeNode;

public class Solution_62 {
/*
 * 给定一颗二叉搜索树，
 * 请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，
 * 按结点数值大小顺序第三个结点的值为4。
 */
    TreeNode KthNode(TreeNode pRoot, int k) {
    	if(pRoot==null||k<=0){
    		return null;
    	}
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=pRoot;
        int count=0;
        while(!stack.isEmpty()||current!=null){
        	while(current!=null){
        		stack.push(current);
        		current=current.left;
        	}
        	current=stack.pop(); 
        	count++;
        	if(count==k){
        		return current;
        	}
        	current=current.right;       	        	
        }
        return null;
    }
}
