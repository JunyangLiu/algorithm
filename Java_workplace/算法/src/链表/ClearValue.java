package 链表;

public class ClearValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode clear(ListNode head, int val) {
       if(head==null){
    	   return null;
       }
       ListNode fakeHead=new ListNode(0);
       fakeHead.next=head;
       ListNode pre=fakeHead;
       ListNode current=head;
       while(current!=null){
    	   if(current.val==val){
    		   pre.next=current.next;
    		   current=pre.next;
    	   }else{
    		   pre=current;
    		   current=current.next;
    	   }
       }
       return fakeHead.next;
    }
}
