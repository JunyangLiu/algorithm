package 剑指offer;

import java.util.Date;

import org.junit.Test;

public class Solution_35 {
/*
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5
 */
    public int InversePairs(int [] array) {
    	if(array==null||array.length==0){
    		return 0;
    	}
    	int[] copy=new int[array.length];

        return mergeCount(array, copy, 0, array.length-1);
    }
    public int mergeCount(int[] array,int[] copy,int start,int end){
//    	System.out.println("start="+start+"  end="+end);
    	if(start==end){
    		return 0;    		
    	}
    	int mid=(start+end)/2;
    	int left=mergeCount(array, copy, start, mid);
    	int right=mergeCount(array, copy, mid+1, end);
    	int count=0;
    	int i=mid;//左子数组的右边界
    	int j=end;//右边数组的右边界
    	int index=end;
    	//统计排序

    	while(i>=start&&j>=mid+1){
    		if(array[i]>array[j]){
    			count+=(j-mid);
    			copy[index--]=array[i--];
    		}else{
    			copy[index--]=array[j--];
    		}
    	}
    	//考虑到有两种极端情况
    	//1 左边数组最小的数都大于右边数组最大的数4 5 6      1 2 3
    	//此时while循环结束时J并没有递减到start+mid+1;
    	//此时 4 5 6都被添加了1 2 3还没添加
    	
    	//2 左边数组最大的数都小于右边数组最小的数 如1 2 3    4 5 6
    	//此时i并没有递减到start，此时 4 5 6都被添加了1 2 3还没添加
    	
    	//以上两种情况只会出现其一
    	for(;i>=start;--i){
    		copy[index--]=array[i];
    	}
    	for(;j>=mid+1;--j){
    		copy[index--]=array[j];
    	}
    	for(i=start;i<=end;i++){
    		array[i]=copy[i];
//    		System.out.print(array[i]+" ");
    	}
//    	System.out.println();
//    	System.out.println("完成一次merge，count="+(left+right+count));
    	return (left+right+count);
    }
    @Test
    public void test(){
    	int[] array={364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
    	System.out.println(InversePairs(array));
    	

    }
}
