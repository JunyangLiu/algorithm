package 剑指offer;



public class Solution_14 {
	/*
	 * 输入一个链表，反转链表后，输出链表的所有元素。
	 */
    public ListNode ReverseList(ListNode head) {
    	if(head==null||head.next==null){
    		return head;
    	}
    	ListNode fakeHead=new ListNode(0);
    	fakeHead.next=head;
    	ListNode current=head;
    	ListNode next=head.next;
    	while(next!=null){
    		current.next=next.next;
    		next.next=fakeHead.next;
    		fakeHead.next=next;
    		next=current.next;
    	}
    	return fakeHead.next;
    }
}
