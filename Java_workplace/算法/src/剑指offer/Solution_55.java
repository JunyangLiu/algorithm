package 剑指offer;

public class Solution_55 {
/*
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
    public ListNode EntryNodeOfLoop(ListNode pHead) {	
    	if(pHead == null || pHead.next == null){
    	return null;
    	}
        ListNode fast=pHead,slow=pHead;
        while(fast!=null){
        	fast=fast.next.next;
        	slow=slow.next;		
        	if(fast==slow){
        	       fast=pHead;
        	        while(fast!=slow){
        	        	fast=fast.next;
        	        	slow=slow.next;		
        	        }
        	        return fast;
        	}
        }
       return null;
    }
}
