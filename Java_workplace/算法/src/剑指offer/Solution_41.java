package 剑指offer;

import java.util.ArrayList;

import org.junit.Test;

public class Solution_41 {
/*
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，
 * 序列间按照开始数字从小到大的顺序
 */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

    	ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    	if(sum<=2){
    		return result;
    	}
        int start=1,end=2;
        int all=0;
        while(start<end){
//        	System.out.println("start="+start+"  end="+end);
            all=(start+end)*(end-start+1)/2;
//            System.out.println("all="+all);
            if(all>sum){
            	start++;
            }else if(all<sum){
            	end++;
            }else{
            	ArrayList<Integer> list=new ArrayList<>();
            	for(int i=start;i<=end;i++){
            		list.add(i);
            		System.out.print(i+ " ");
            	}
            	System.out.println();
            	result.add(list);
            	end++;
          }
        }
        return  result;
    }
    @Test
    public void test(){
    	FindContinuousSequence(9);
    }
}
