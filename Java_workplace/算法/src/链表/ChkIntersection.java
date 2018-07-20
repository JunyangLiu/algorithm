package 链表;

public class ChkIntersection {
/*
 * 如何判断两个有环单链表是否相交？
 * 相交的话返回第一个相交的节点，不想交的话返回空。
 * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，
 * 额外空间复杂度O(1)。
 * 给定两个链表的头结点head1和head2(注意，
 * 另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode interNode1=chkLoop(head1);
        ListNode interNode2=chkLoop(head2);
        if(interNode1==interNode2){
        	return true;
        }
        
        ListNode cur=interNode1.next;
        while(cur!=interNode1){
        		if(cur==interNode2){
        			return true;
        		}
        		cur=cur.next;
        }
    	
    	return false;
    }
    public ListNode chkLoop(ListNode head) {
         ListNode fast=head;
         ListNode slow=head;
         while(fast!=null&&fast.next!=null){
      	   fast=fast.next.next;
      	   slow=slow.next;
      	   if(fast==slow)
      	   break;     	   
         }
         fast=head;
		   
         if(fast == null || fast.next == null) return null;
         fast = head;
         while(fast!=slow){
             fast = fast.next;
             slow = slow.next;
         }
         return fast;
      }
}
