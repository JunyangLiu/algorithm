package 剑指offer;

import java.util.ArrayList;

import org.junit.Test;

public class Solution_42 {
/*
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    	ArrayList<Integer> result=new ArrayList<>();
        if(array==null||array.length<2){
        	return result;
        }

        int start=0,end=array.length-1;
        while(start<end){
        	if(array[start]+array[end]<sum){
        		start++;
        	}else if(array[start]+array[end]>sum){
        		end--;
        	}else{
        		result.add(array[start]);
        		result.add(array[end]);
        		break;
        	}
        }
        return result;
    }
    @Test
    public void test(){
    	int[] array={1,2,3,4,5,6};
    	FindNumbersWithSum(array, 7);
    }
}
