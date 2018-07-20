package tree;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class PostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
    	 Stack<TreeNode> stack=new Stack<TreeNode>();
		 List<Integer> list=new ArrayList<>();
		 TreeNode current=root;
		 int state=0;
		 	while(current!=null||!stack.isEmpty()){
		 		
		 		//出栈：状态加一表示执行下一个程序
		 		while(!stack.isEmpty()&&current==null){
		 			current=stack.peek();
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
					current=current.right;			
		
				case 2:			
					System.out.println(stack.pop().val);
					current=stack.pop();
					state=0;
					break;
					
				default:
					break;
				}
		 	}
		 	for(Integer i:list){
		 		System.out.print(i);
		 	}
		 	return list;
    }
    @Test
	   public void test(){
		   Integer[] array={1,2,3,4,5,6,7};
		   TreeNode root=BinaryTreeHelper.arrayToBinaryTree(array, null);
//		   BinaryTreeHelper.preorderPrintTree(root);
		   postorderTraversal(root);
	   }  

}
