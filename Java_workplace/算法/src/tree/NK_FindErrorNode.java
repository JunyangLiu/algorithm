package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class NK_FindErrorNode {
	/*
	 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
	 * 使得这棵二叉树不再是搜索二叉树，
	 * 请找到这两个错误节点并返回他们的值。
	 * 保证二叉树中结点的值各不相同。
	 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前
	 */
    public int[] findError(TreeNode root) {
        int[] result=new int[2];
        boolean flag=true;
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        TreeNode current=root;
        while(!stack.isEmpty()||current!=null){

        	while(current!=null){
        		stack.push(current);
        		current=current.left;
        	}
        	current=stack.pop();
        	list.add(current.val);
        	current=current.right;
        	
        }
        for(int i=1;i<list.size();i++){

        	if(list.get(i-1)>list.get(i)){
        		if(flag){
        			result[0]=list.get(i);
        			result[1]=list.get(i-1);
        			flag=false;
        		}else{
        			result[0]=list.get(i);
        		}
        	}
        }

        return result;
    }
	   @Test 
	   public void test(){
	    	Integer[] array={4,2,6,1,3,5,7};
	    	TreeNode root=BinaryTreeHelper.arrayToBinaryTree(array, null);
		   findError(root);
	   }
}
