package 链表;

public class KInverse {
	public static void main(String[] args) {
		int[] a={0,4,9,11,12,14,20,24};
		ListNode head=LinkListHelper.build(a);
		head=inverse(head, 2);
		LinkListHelper.print(head);
	}
    public static ListNode inverse(ListNode head, int k) {
    	if(head==null||head.next==null){
    		return head;
    	}
       ListNode node=head;
       ListNode fakeHead=new ListNode(0);
       fakeHead.next=head;
       ListNode pre=fakeHead;
       ListNode cur=head;
       ListNode next=head.next;
       

       int count=0;
       while(node!=null){
    	   node=node.next;
    	   count++;
       }
       //一共要更新长度为k的链表  count/k 段
       for(int i=0;i<count/k;i++){
    	   for(int j=0;j<k-1;j++){
               next=cur.next;
               cur.next=next.next;
               next.next=pre.next;
               pre.next=next;

    	   }
    	   pre=cur;
    	   cur=cur.next;

       }
       return fakeHead.next;
    }
}
