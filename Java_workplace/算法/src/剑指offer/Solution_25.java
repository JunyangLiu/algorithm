package 剑指offer;

import java.util.Stack;

import tree.TreeNode;

public class Solution_25 {
/*
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
    public TreeNode Convert(TreeNode pRootOfTree) {
    	if(pRootOfTree==null){
    		return null;
    	}
    	
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=pRootOfTree;
        TreeNode pre=null;
        TreeNode head=null;
        boolean flag=true;//用来保存第一个节点的标识
        while(!stack.isEmpty()||current!=null){
        	while(current!=null){
        		stack.push(current);
        		current=current.left;
        	}
        	TreeNode node=stack.pop();
        	if(flag){
        		head=node;
        		flag=false;
        	}
        	if(pre!=null){
        		pre.right=node;
        	}
        	node.left=pre;
        	pre=node;   
        	current=node.right;
        }
        return head;
    }
}
