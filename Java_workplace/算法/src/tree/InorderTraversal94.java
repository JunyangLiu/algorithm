package tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class InorderTraversal94 {
	//morris遍历
	 public List<Integer> inorderTraversal0(TreeNode root) {
	        if(root == null) return new ArrayList<Integer>();
	        List<Integer> res = new ArrayList<Integer>();
	        TreeNode pre = null;
	        while(root != null){
	        	if(root.left == null){
	        		res.add(root.val);
	        		root = root.right;
	        	}else{
	        		pre = root.left;
	        		while(pre.right != null && pre.right != root){
	        			pre = pre.right;
	        		}
	        		if(pre.right == null){
	        			pre.right = root;
	        			root = root.left;
	        		}else{
	        			pre.right = null;
	        			res.add(root.val);
	        			root = root.right;
	        		}
	        	}
	        }
	        return res;
	    }
	
	 public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> list=new ArrayList<>();
	        Stack<TreeNode> stack=new Stack<TreeNode>();
	        
	        TreeNode currentNode=root;
	        while(currentNode!=null||!stack.isEmpty()){
	        	//如果左孩不为空，则一直添加进栈
	        	while(currentNode!=null){
	        		stack.push(currentNode);
	        		currentNode=currentNode.left;
	        	}
	        	//左孩为空则输出当前元素（也就是栈顶元素），模仿中序遍历
	        	//然后往栈里添加当前元素的右孩
	        		currentNode=stack.pop();
	        		list.add(currentNode.val);  
	        		
	             	currentNode=currentNode.right;     	

	        }
	        return list;
	    }
	 public List<Integer> inorderTraversal2(TreeNode root) {
		 Stack<TreeNode> stack=new Stack<TreeNode>();
		 List<Integer> list=new ArrayList<>();
		 TreeNode current=root;
		 int state=0;
		 	while(current!=null||!stack.isEmpty()){
		 		//出栈：状态加一表示执行下一个程序
		 		while(!stack.isEmpty()&&current==null){
		 			current=stack.pop();
		 			state++;
		 		}
		 		if(current==null){
		 			break;
		 		}
		 		switch (state) {
				case 0:

					stack.push(current);
					current=current.left;

					break;
				case 1:
					list.add(current.val);
					state++;
					break;
				case 2:			
					current=current.right;			
					state=0;
					break;
				default:
					break;
				}
		 	}

		 	return list;

	    }

	 
	   @Test
	   public void test(){
		   Integer[] array={1,2,3,4,5,6,7};
		   TreeNode root=BinaryTreeHelper.arrayToBinaryTree(array, null);
//		   BinaryTreeHelper.preorderPrintTree(root);
		   inorderTraversal2(root);
	   }  
  
}
