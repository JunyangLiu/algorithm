package 剑指offer;



public class Solution_13 {
	/*
	 * 输入一个链表，输出该链表中倒数第k个结点
	 */
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(head==null||k<=0){
    		return null;
    	}
    	ListNode fast=head,slow=head;
    	for(int i=0;i<k-1;i++){
    		fast=fast.next;
    	}
    	if(fast==null){
    		return null;
    	}
    	while(fast.next!=null){
    		fast=fast.next;
    		slow=slow.next;
    	}
    	return slow;
    }
}
