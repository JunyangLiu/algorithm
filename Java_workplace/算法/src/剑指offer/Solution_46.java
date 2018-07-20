package 剑指offer;

import org.junit.Test;

public class Solution_46 {
    public int LastRemaining_Solution(int n, int m) {
    	if(n==0||m==0){
    		return -1;
    	}
    	ListNode head=new ListNode(-1);
    	ListNode node=head;
        for(int i=0;i<n;i++){
        	ListNode current=new ListNode(i);
        	node.next=current;
        	node=current;
        }
        node.next=head.next;
        //模拟删除过程
        node=head;
        //找到删除节点的前一个
        while(node.next!=node){
            for(int i=1;i<m;i++){
            	node=node.next;
        }
            node.next=node.next.next;
        }
        return node.val;
    }
    class ListNode{
    	int val;
    	ListNode next;
    	public ListNode(int val) {
			this.val=val;
		}
    }
    @Test
    public void test(){

    	System.out.println(LastRemaining_Solution(5, 3));
    }
}
