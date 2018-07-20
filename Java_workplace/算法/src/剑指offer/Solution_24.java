package 剑指offer;

public class Solution_24 {
	/*
	 * 输入一个复杂链表
	 * （每个节点中有节点值，
	 * 以及两个指针，一个指向下一个节点，
	 * 另一个特殊指针指向任意一个节点），
	 * 返回结果为复制后复杂链表的head。
	 * （注意，输出结果中请不要返回参数中的节点引用，
	 * 否则判题程序会直接返回空）
	 */
    public RandomListNode Clone(RandomListNode pHead){
    if(pHead==null){
    	return null;
    }

    	RandomListNode current=pHead;
    	//复制链表
		while(current!=null){
			RandomListNode node=new RandomListNode(current.label);
			node.next=current.next;
			current.next=node;
			current=node.next;
		}
		//分配random指针
		current=pHead;
		while(current!=null){
			if(current.random!=null){
				current.next.random=current.random.next;
			}
			current=current.next.next;
		}
//		RandomListNode pre=pHead;
//		current=pHead.next;
//    	while(current!=null){
//    		if(current.random==null){
//    			current.random=pre.random.next;
//    		}
//    		pre=current.next;
//    		current=current.next.next;
//    	}
    	//拆分
    	RandomListNode newhead=pHead.next;
    	RandomListNode pre=pHead;
    	current=pHead.next;
    	while(current!=null){
    		pre.next=current.next;
    		pre=current;
    		current=current.next;
    	}


    	return newhead;
    }
    

    public void connectRandom(RandomListNode node){
    	RandomListNode pre=node,current=node.next;
    	while(current!=null){
    		if(current.random==null){
    			current.random=pre.random.next;
    		}
    		pre=current;
    		current=current.next;
    	}
    	
    }

     class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
