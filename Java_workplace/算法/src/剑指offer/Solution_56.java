package 剑指offer;

public class Solution_56 {
/*
 * 题目描述
在一个排序的链表中，存在重复的结点，
请删除该链表中重复的结点，重复的结点不保留，
返回链表头指针。
 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
    public ListNode deleteDuplication(ListNode pHead){
    	if(pHead==null||pHead.next==null){
    		return pHead;
    	}
    	ListNode fakeHead=new ListNode(0);
    	fakeHead.next=pHead;
    	ListNode pre= fakeHead,current=pHead,next=pHead.next;
    	while(next!=null){
    		if(next.val==current.val){
    			while(next!=null&&next.val==current.val){
        			current=next;
        			next=current.next;
    			}
    			current=next;
    			if(next!=null)
    			next=current.next;
    			pre.next=current;
    		}else{
    			pre=current;
    			current=next;
    			next=current.next;
    		}
    	}
    	return fakeHead.next;
    }
}
