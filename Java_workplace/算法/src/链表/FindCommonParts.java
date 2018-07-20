package 链表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindCommonParts {

	public static void main(String[] args) {
//		ListNode a=LinkListHelper.build({0,3,9,11,15,21,27,28,31})
//		ListNode b=LinkListHelper.build({0,1,3,5,11,16,17,20,25});

	}
    public static int[] findCommonParts(ListNode headA, ListNode headB) {
       HashSet<Integer> set=new HashSet<>();
       List<Integer> result=new ArrayList<>();
      
       while(headA!=null){
    	   set.add(headA.val);
    	   headA=headA.next;
       }
       int i=0;
       while(headB!=null){
    	   if(set.contains(headB.val)){
    		   result.add(headB.val);
    		   i++;
    	   }
    	   headB=headB.next;
       }
       int[] data=new int[result.size()];
       for(int j=0;j<result.size();j++){
    	   data[j]=result.get(j);
       }
 		return data;
    }
}
