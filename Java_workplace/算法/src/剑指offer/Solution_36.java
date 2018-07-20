package 剑指offer;

public class Solution_36 {
	/*
	 * 输入两个链表，找出它们的第一个公共结点。
	 */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	int k1=0,k2=0;
    	ListNode node=pHead1,node2;
    	while(node!=null){
    		node=node.next;
    		k1++;
    	}
    	node=pHead2;
    	while(node!=null){
    		node=node.next;
    		k2++;
    	}
    	if(k1>k2){
    		node=pHead1;
    		node2=pHead2;
    	}else{
    		node=pHead2;
    		node2=pHead1;
    	}
    	for(int i=1;i<=k1-k2;i++){
    		node=node.next;
    	}
    	
    	while(node!=null&&node2!=null){
    		if(node==node2){
    			return node;
    		}
    		node=node.next;
    		node2=node2.next;
    	}
    	return null;
    }
}
