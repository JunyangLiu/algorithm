package 剑指offer;

import org.junit.Test;

public class Solution_27 {
	/*
	 * 数组中有一个数字出现的次数超过数组长度的一半，
	 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
	 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
	 * 如果不存在则输出0。
	 */
    public int MoreThanHalfNum_Solution(int [] array) {
    	if(array==null||array.length==0){
    		return 0;
    	}
        int result=array[0];
        int pre=result;
        int count=0;
        for(int i=0;i<array.length;i++){
        	if(array[i]==pre||count==0){
        		result=array[i];
        		count++;
        	}else{
        		
        	}
        	pre=array[i];
        }
        if(count>0){
        	count=0;
        	for(int i=0;i<array.length;i++){
        		if(array[i]==result){
        			count++;
        		}
        	}
        	if(count>array.length/2){
        		return result;
        	}else{
        		return 0;
        	}
        	
        }else{
        	return 0;
        }
    }
 @Test
 public void test(){
	 int[] array={1,2,1,2};
	 System.out.println(MoreThanHalfNum_Solution(array));
 }
}
