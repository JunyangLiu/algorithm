package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NK_TreeToSequence {
/*
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，
 * 中序和后续遍历(二维数组的形式)。
 */
	public static void main(String[] args) {
		   Integer[] array={1,2,3,4,5,6};
			
		   TreeNode root=BinaryTreeHelper.arrayToBinaryTree(array, null);


	}
    public  int[][] convert(TreeNode root) {
    	  List<Integer> preorderList = new ArrayList<Integer>();
          List<Integer> inorderList = new ArrayList<Integer>();
          List<Integer> postorderList = new ArrayList<Integer>();
   
          preorderList=preOrder(root);
          inorderList=inOrder(root);
          postorderList=postorder(root);
   
          int length = preorderList.size();
          int[][] result = new int[3][length];
   
          for(int i = 0; i < length; i++) {
              result[0][i] = preorderList.get(i);
          }
   
          for(int i = 0; i < length; i++) {
              result[1][i] = inorderList.get(i);
          }
   
          for(int i = 0; i < length; i++) {
              result[2][i] = postorderList.get(i);
          }
   
          return result;
    }
   /* 
    * 先序遍历
    * 思路：利用栈，每次弹出栈顶
    * 并按顺序添加栈顶节点的右孩和左孩
    */
    public List<Integer> preOrder(TreeNode root){
    	Stack<TreeNode> stack=new Stack<>();
    	List<Integer> list=new ArrayList<>();
    	if(root==null)
			return null;

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
    	return list;   	
    }
        public   List<Integer> inOrder(TreeNode root){
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
   /*
    * 思路：如果按照 右孩，左孩，根节点 顺序的做 “先序遍历 ”
    * 得到的结果进行逆序刚好就是后续遍历    
    */
        public  List<Integer> postorder(TreeNode root) {
        	LinkedList<Integer> ans = new LinkedList<>();
        	Stack<TreeNode> stack = new Stack<>();
        	if (root == null) return ans;
        	
        	stack.push(root);
        	while (!stack.isEmpty()) {
        		TreeNode cur = stack.pop();
        		ans.addFirst(cur.val);
        		if (cur.left != null) {
        			stack.push(cur.left);
        		}
        		if (cur.right != null) {
        			stack.push(cur.right);
        		} 
        	}
        	return ans;
        }
}

