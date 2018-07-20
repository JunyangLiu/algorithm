package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class PreorderTraversal144 {
	List<Integer> list=new ArrayList<>();
	Stack<TreeNode> stack=new Stack<>();
    public List<Integer> preorderTraversal(TreeNode root) {
    	if(root==null){
    			return null;
    	}else{
    		stack.push(root);
    		TreeNode currentNode;
    		while(!stack.isEmpty()){
    			currentNode=stack.pop();
    			list.add(currentNode.val);
    			if(currentNode.right!=null){
    				stack.push(currentNode.right);
    			}
    			if(currentNode.left!=null){
    				stack.push(currentNode.left);
    			}
    		}
    	 	for(Integer i:list){
        		System.out.print(i+" ");
        	}
        	return list;
    	}
   
    }
    //模拟栈法
    public List<Integer> preorderTraversal1(TreeNode root) {
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
					list.add(current.val);
					stack.push(current);
					current=current.left;

					break;
				case 1:
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
		   preorderTraversal(root);
	   }  
    
}
