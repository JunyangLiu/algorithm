package 链表;

public class LinkListHelper {
	public static ListNode build(int[] data){
		ListNode head=new ListNode(data[0]);
		ListNode pre=head;
		for(int i=1;i<data.length;i++){
			ListNode node=new ListNode(data[i]);
			pre.next=node;
			pre=node;
		}
		pre.next=null;
		return head;
	}
	public static void print(ListNode node){
		while(node!=null){
			System.out.print(node.val+"  ");
			node=node.next;
		}
	}
}
