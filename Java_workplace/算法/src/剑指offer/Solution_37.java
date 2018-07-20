package 剑指offer;

import org.junit.Test;

public class Solution_37 {
/*
 * 统计一个数字在排序数组中出现的次数。
 * 思路1：找出数字第一次出现的位置，然后往后数
 * 思路2：找出数字最后一次出现的位置，和第一次出现的位置然后相减
 */
    public int GetNumberOfK(int [] array , int k) {
    	if(array==null||array.length==0){
    		return 0;
    	}
        int start=0,end=array.length-1,mid=0;
        //找到k出现的第一个位置
        while(start<end){
        	mid=(start+end)/2;
        	if(array[mid]>k){
        		end=mid-1;
        	}else if(array[mid]<k){
        		start=mid+1;
        	}else {
				end=mid;
			}
        }
        if(array[start]!=k){
        	return 0;
        }
        int result=0;
        while(start<array.length&&array[start++]==k){
        	result++;
        }
        return result;
    }
    @Test
    public void test(){
    	int[] array={1,2,3,3,3,3};
	System.out.println(GetNumberOfK(array, 3));
    	

    }
}
