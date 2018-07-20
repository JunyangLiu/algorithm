package 链表;

public class Devide {
/*
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，
 * 使得小于等于这个值的结点移到前面，大于该值的结点在后面，
 * 同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，
 * 请返回一个链表，使小于等于它的结点在前，
 * 大于等于它的在后，保证结点值不重复。
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 */
	/*
	 * 思路：遍历链表，把小于等于阈值的节点都插入到前面的位置中
	 * 定义三个节点
	 * tail 小于等于阈值的队尾节点
	 * pre 遍历的前一个节点
	 * current 遍历的当前节点
	 * 为了便于插入可以定义一个假头部dummy进行操作
	 * 同时dummy的值可以让它小于阈值，作为初始的tail
	 * 遍历到的符合条件的节点不断插入tail的后面
	 * 注意，这个题目要求只要小于阈值的节点放在前边就行，顺序无关紧要
	 * 会出现四种情况
	 *  pre.val>val&&current.val<=val   把current 插入tail后面，【更新tail】
	 *  pre.val>val&&current.val>val      跳过，不用更新tail
	 *  pre.val<=val&&current.val<=val  跳过，【需要更新tail】
	 *  pre.val<=val&&current.val>val    跳过，不用更新tail
	 * 只有符合 pre.val>val&&current.val<=val条件的才需要插入
	 * 只要当前current符合小于的条件都要更新tail
	 * 跳过是指不用进行插入操作
	 * 
	 */
	public static void main(String[] args) {
		int[] a={1,2,4,1};
		ListNode head=LinkListHelper.build(a);
		ListNode newHead=listDivide(head, 3);
		LinkListHelper.print(newHead);

	}
    public static ListNode listDivide(ListNode head, int val) {
    	if (head==null||head.next==null) {
			return null;
		}
        ListNode dummy=new ListNode(val-1);
        dummy.next=head;
        ListNode pre,current,tail;
        tail=dummy;
        pre=dummy;
        current=head;
        while(current!=null){
        	if(pre.val>val&&current.val<=val){  
        		//链表翻转
        		pre.next=current.next;
        		current.next=tail.next;
        		tail.next=current;
        		//重新初始化
        		tail=current;
        		current=pre.next;
        	}else if(pre.val<=val&&current.val<=val){
        		tail=current;
        		pre=current;
        		current=current.next;
        	}else{
        		pre=current;
        		current=current.next;
        	}
        }
        return dummy.next;
    }
}
