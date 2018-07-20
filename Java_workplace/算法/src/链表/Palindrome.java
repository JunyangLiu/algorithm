package 链表;

import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPalindrome(ListNode pHead) {
        ListNode node=pHead;
        Stack<Integer> stack=new Stack<>();
        int count=0;
        while(node!=null){
        	count++;
        	node=node.next;
        }
        node=pHead;
        for(int i=0;i<count/2;i++){
        	stack.push(node.val);
        	node=node.next;
        }
        if(count%2==1){
        	node=node.next;
        }
        while(node!=null){
        	if(stack.pop()!=node.val){
        		return false;
        	}
        	node=node.next;
        }
        return true;
    }
}
