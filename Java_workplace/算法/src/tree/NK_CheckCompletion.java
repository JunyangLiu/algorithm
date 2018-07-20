package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class NK_CheckCompletion {
	/*
	 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
	 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。
	 * 树的结点个数小于等于500。
	 */
    public boolean chk(TreeNode root) {
    	if(root==null){
    		return true;
    	}
       TreeNode current;
       boolean flag=false;//这个值表示之前是否出现过不是左右孩子都有的节点
        Queue<TreeNode> queue=new LinkedList<>();
        List<TreeNode> list=new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	current=queue.poll();
        	list.add(current);
        	if(current.left!=null){
        		queue.offer(current.left);
        	}if(current.right!=null){               
        		queue.offer(current.right);
        	}
        }
        for(TreeNode node:list){
        	if(node.left==null&&node.right!=null){
        		System.out.println(38);
        		return false;
        	}
        	if(node.left==null||node.right==null){
        		flag=true;
        		continue;
        	}
        	if(flag&&(node.left!=null||node.right!=null)){
        		return false;
        	}
        }
        return true;
    }
    @Test
    public void Test(){
    	Integer[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    	TreeNode root=BinaryTreeHelper.arrayToBinaryTree(array, null);
    	System.out.println(chk(root));
    }
}
