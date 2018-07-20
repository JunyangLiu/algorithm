package 链表;

public class CheckIntersect {
/*
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，
 * 请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，
 * 判断这两个链表是否相交。
 * 定两个链表的头结点headA和headB，
 * 请返回一个bool值，代表这两个链表是否相交。
 * 保证两个链表长度小于等于500。
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        ListNode node=headA;
        int m=0,n=0,count=0;
        while(node!=null){
        	m++;
        	node=node.next;
        }
        node=headB;
        while(node!=null){
        	n++;
        	node=node.next;
        }
        
        if(m>n){
        	count=m-n;
            for(int i=0;i<count;i++){
            	headA=headA.next;
            }
        }else{
        	count=n-m;
            for(int i=0;i<count;i++){
            	headB=headB.next;
            }
        }
        while(headA!=null&&headB!=null){
        	if(headA==headB){
        		return true;
        	}
        	headA=headA.next;
        	headB=headB.next;
        }
    return false;
    }
}
