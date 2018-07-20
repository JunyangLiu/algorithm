package 剑指offer;

import tree.TreeNode;

public class Solution_61 {
/*
 * 请实现两个函数，
 * 分别用来序列化和反序列化二叉树
 */

    String Serialize(TreeNode root) {
    	StringBuilder sb=new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
  }
    void preOrder(TreeNode node,StringBuilder sb){
    	if(node==null){
    		sb.append("#,");
    		return;
    	}
    	sb.append(node.val);
    	sb.append(',');
    	preOrder(node.left, sb);
    	preOrder(node.right, sb);
    }
    TreeNode Deserialize(String str) {
    	if(str.length()==0){
    		return null;
    	}
       String [] s=str.split(",");
       return decode(s);
  }
    int index=-1;
    TreeNode decode(String[] s){
    	index++;
    	if(!s[index].equals("#")){
    		TreeNode node=new TreeNode(Integer.parseInt(s[index]));
    		node.left=decode(s);
    		node.right=decode(s);
    		return node;
    	}
    	return null;
    }

}
