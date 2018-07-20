package tree;

public class CountNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
/*
 * 题目：给定一棵完全二叉树的根节点root，
 * 返回这棵树的节点个数。如果完全二叉树的节点数为N，
 * 请实现时间复杂度低于O(N)的解法。
 * 给定树的根结点root，请返回树的大小。
 * 思路：
 * 可以分为两种情况递归
 * 1：
 * 当前节点的右子树的最大深度 等于 当前节点数的最大深度
 * 此时说明当前节点的左子树为满二叉树可以用公式计算。2的h - level次方
 * 然后递归右子树
 * 2：当前节点的右子树的最大深度小于 当前节点数的最大深度
 * 说明说明当前节点的右子树为满二叉树可以用公式计算。2的h - level-1次方
 * 然后递归左子树
 */
    public int count(TreeNode root) {
        if(root==null){
        	return 0;
        }
        return bs(root, 1, mostLeftLevel(root, 1));
    }
    //level是当前节点处在的层数
    public int bs(TreeNode node, int level, int h) {
		if (level== h) {
			return 1;
		}
		if (mostLeftLevel(node.right, level + 1) == h) {
			return (1 << (h - level)) + bs(node.right, level + 1, h);
		} else {
			return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
		}
	}
    public int mostLeftLevel(TreeNode node,int level){
    	while(node!=null){
    		level++;
    		node=node.left;
    	}   
    	return level-1;
    }
}
