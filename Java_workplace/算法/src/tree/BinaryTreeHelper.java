package tree;

import java.util.ArrayList;
import java.util.List;


public  class BinaryTreeHelper {
/**
 * 数组表示法转换为二叉链表
 */
public static TreeNode arrayToBinaryTree(Integer [] array, Integer nullValue){
	if(array==null||array.length==0){
		return null;
	}else{
		List<TreeNode> tempList=new ArrayList<TreeNode>();
		TreeNode root=new TreeNode(array[0]);
		tempList.add(root);
		int index=1;
		loop:
		while(tempList.size()>0&&index<array.length){
			List<TreeNode> newList=new ArrayList<TreeNode>();
			for(TreeNode node:tempList){
				if(index==array.length){
					break loop;
				}
				if(array[index]!=null&&(array[index]!=(nullValue))){
					node.left=new TreeNode(array[index]);
					newList.add(node.left);
				}
				index++;
				if(index==array.length){
					break loop;
				}
				if(array[index]!=null&&(array[index]!=nullValue)){
					node.right=new TreeNode(array[index]);
					newList.add(node.right);
				}
				index++;
			}
			tempList=newList;
		}
		return root;
	}
}
/*
 * 前序打印一棵二叉树
 */
public static  void preorderPrintTree(TreeNode root){
	if(root==null){
		return;
	}
	System.out.print(root.val+" ");
	preorderPrintTree(root.left);
	preorderPrintTree(root.right);	
}
/*
 * 中序打印一棵二叉树
 */
public static  void InorderPrintTree(TreeNode root){
	if(root==null){
		return;
	}
	InorderPrintTree(root.left);
	System.out.print(root.val+" ");
	InorderPrintTree(root.right);	
}
/*
 * 后序打印一棵二叉树
 */
public static  void posorderPrintTree(TreeNode root){
	if(root==null){
		return;
	}
	posorderPrintTree(root.left);
	posorderPrintTree(root.right);	
	System.out.print(root.val+" ");

}
}
