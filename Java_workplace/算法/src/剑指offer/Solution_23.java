package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

import tree.TreeNode;

public class Solution_23 {
/*
 * 输入一颗二叉树和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 思路亮点在于    list.remove(list.size()-1);
 */
	

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    if(root==null){
    	return listAll;
    }
    list.add(root.val);
    if(target==root.val&root.right==null&&root.left==null){
    	listAll.add(new ArrayList<>(list));
    }
    FindPath(root.left, target-root.val);
    FindPath(root.right, target-root.val);
    list.remove(list.size()-1);
    return listAll;
    }

}
