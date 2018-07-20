package 链表;


public class Remove {
	
	public static void main(String[] args) {
		
	}
    public boolean removeNode(ListNode pNode) {
        if(pNode==null||pNode.next==null){
        	return false;
        }
        pNode=pNode.next;
        return true;
    }
}
