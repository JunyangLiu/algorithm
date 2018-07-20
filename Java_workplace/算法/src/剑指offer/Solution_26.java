package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Solution_26 {
	/*
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
	 * 例如输入字符串abc,
	 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
	 * 输入描述:
	 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
	 */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result=new ArrayList<>();
        char[] arr=str.toCharArray();
        if(arr==null||arr.length==0){
        	return result;
        }
        Arrays.sort(arr);
        result.add(String.valueOf(arr));
        int len=arr.length;
        while(true){
        	int i=len-1;
        	//找出第一个arr[i-1]<arr[i]的位置
        	while(i>=1&&arr[i-1]>=arr[i])i--;
        	//如果i循环到0，说明当前排列已经是最小字典排列像1234567这样子
        	if(i==0)break;
        	int index=i;//找出最后一个大一arrp[i-1]的数
        	for(int j=i;j<arr.length;j++){
        		if(arr[j]>arr[i-1]){
        			index=j;
        		}
        	}
        	//然后交换arr[i-1],和arr[index];
        	swap(arr, i-1, index);
        	//翻转arr[i-1]后的序列
        	reverse(arr, i);
        	result.add(String.valueOf(arr));
        }
        return result;
    }
    public void reverse(char[] arr,int start){
    	if(start<0)return;
    	int end=arr.length-1;
    	while(start<end){
    		swap(arr, start, end);
    		start++;
    		end--;
    	}
    }
    public void  swap(char[] arr ,int i,int j) {
    	if(j<=i)return;
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
    @Test
    public void test(){
    	int i=5;
    	while(i>=1)i--;
    	System.out.println(i);
    }
}
