package 剑指offer;

import org.junit.Test;





public class Solution_15 {
	/*
	 * 输入两个单调递增的链表，
	 * 输出两个链表合成后的链表，
	 * 当然我们需要合成后的链表满足单调不减规则
	 */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode fakeHead=new ListNode(0);
        ListNode pre=fakeHead;
        while(!(list1==null&&list2==null)){
        	if(list1==null){
        		pre.next=list2;
        		pre=list2;
        		list2=list2.next;
        	}else if(list2==null){
        		pre.next=list1;
        		pre=list1;
        		list1=list1.next;
        	}else{
            	if(list1.val<list2.val){
            		pre.next=list1;
            		pre=list1;  
            		list1=list1.next;
            	}else{
            		pre.next=list2;
            		pre=list2;
            		list2=list2.next;
            	}
        	}
        }

        return fakeHead.next;
    }

  public ListNode buildList(int[] data) {
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
	public  void print(ListNode node){
		while(node!=null){
			System.out.print(node.val+"  ");
			node=node.next;
		}
	}
@Test
public void test(){
	int[] a={1,3,5,7};
	int[] b={2,4,6,8};
	ListNode aNode=buildList(a);
	ListNode bNode=buildList(b);
	print(Merge(aNode, bNode));
}
}
