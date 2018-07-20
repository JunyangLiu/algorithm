package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution_32 {
	/*
	 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
	 * 打印能拼接出的所有数字中最小的一个。
	 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	 */
    public String PrintMinNumber(int [] numbers) {
    	 ArrayList<Integer> list= new ArrayList<Integer>();
    	  int n=numbers.length;
    	  for(int i=0;i<n;i++){
    	   list.add(numbers[i]);
    	  }
    	Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer string1, Integer string2) {
				String s1=string1+""+string2;
				String s2=string2+""+string1;
				return s1.compareTo(s2);
			}
		});
    	StringBuilder sb=new StringBuilder();
    	for(Integer i:list){
    		sb.append(i+"");
    	}
    	return sb.toString();
    }
 
}
