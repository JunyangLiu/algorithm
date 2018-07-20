package 链表;

import java.io.BufferedWriter;

public class InsertValue {
	/*
	 * 题目：有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。

给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。

测试样例：
[1,3,4,5,7],[1,2,3,4,0],2
返回：{1,2,3,4,5,7}
	 */

	public static void main(String[] args) {
		int[] A={1,3,4,5,7};
		int[] next={1,2,3,4,0};
		ListNode node=insert(A, next, 2);
		for(int i=0;i<6;i++){
			System.out.print(node.val+" ");
			node=node.next;
		}

	}
	/*
	 * 思路：
	 * 1、如果原链表为空
	 * 2、如果原链表不为空
	 * 3、转一圈寻找插入位置，如果都没有找到，
	 * 说明这个数最大或者最小，
	 * 只要把这个数插入到head前面就行
	 */
   static public ListNode insert(int[] A, int[] nxt, int val) {
	   //链表为空的情况
        if(A.length==0||A==null){
        ListNode head=new ListNode(val);
        head.next=head;
        }
        
    	ListNode head=new ListNode(A[0]);
    	ListNode pre=head;
    	boolean flag=false; //是否插入成功的标志
    	//链表长度为1 的情况
        if(A.length==1){
        	ListNode current=new ListNode(val);
        	head.next=current;
        	current.next=head;
        	return head;
        }
        for(int i=1;i<A.length;i++){
        	ListNode current=new ListNode(A[i]);
        	if(val>=pre.val&&val<current.val){
        		ListNode node=new ListNode(val);
        		pre.next=node;
        		node.next=current;
        		flag=true;
        	}else{
            	pre.next=current;
        	}

        	pre=current;
        }
        if(!flag){
    		ListNode node=new ListNode(val);
    		pre.next=node;
      		node.next=head;
        }else{
        	pre.next=head;
        }
        return head;
    }
}
