package tree;

import org.hamcrest.core.Is;

public class NK_CheckBalance {
/*
 * 有一棵二叉树，
 * 请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根结点root，请返回一个bool值，
 * 代表这棵树是否为平衡二叉树
 */

    public boolean check(TreeNode root) {
        boolean[] res=new boolean[1];
        //从根节点开始遍历树，遍历过程中修改平衡标记
        res[0]=true;
    	getDepth(root, 1, res);
    	return res[0];
    	
        
    }
    public int getDepth (TreeNode root,int level,boolean[] res){
    	if(root==null){
    		return level;
    	}
    	int lDepth=getDepth(root.left, level+1, res);
    	if(!res[0]){
    		return level;
    	}
    	int rDepth=getDepth(root.right, level+1, res);
    	if(!res[0]){
    		return level;
    	}
    	if(Math.abs(lDepth-rDepth)>1){
    		res[0]=false;
    	}
		return Math.max(lDepth, rDepth);
    }
}
