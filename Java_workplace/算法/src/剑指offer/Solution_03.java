package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;


/*
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Solution_03 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result=new ArrayList<>();
        print(listNode, result);
        return result;
    }
    public void print(ListNode node,ArrayList<Integer> result){
    	if(node==null){
    		return;
    	}
    	print(node.next, result);
    	result.add(node.val);
    }

 class ListNode {
      int val;
      ListNode next = null;
      ListNode(int val) {
                this.val = val;           
      }
      }

}
