package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import 排序算法.SortUtils;

public class CheckTransform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {  	
    	if(A == null || B == null || lena != lenb){//判空
            return false;
        }
    	char[] a=A.toCharArray();
    	char[] b=B.toCharArray();
    	int [] map=new int[256];
    	
    	for(int i=0;i<a.length;i++){//计数
    		map[a[i]]++;
    	}
 	   for(int i=0;i<b.length;i++){//比对
 		   if(map[b[i]--]==0){
 			   return false;
 		   }
 	   }
 	   return true;
    }

    
    /*
     * 
     * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，
     * 也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
     * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
     * 测试样例：
     * "dog loves pig",13
     * 返回："pig loves dog"
     */
    public String reverseSentence(String A, int n) {
    	if(A==null||A.isEmpty()){
    		return null;
    	}
       char [] a=A.toCharArray();
       int last=0;
       for(int i=0;i<a.length;i++){
    	   if(a[i]==' '){  		
    			  reverse(a, last, i-1);
    			  last=i+1;
    	   }
       }
       reverse(a, last, n-1);
       reverse(a, 0, n-1);
       return     String.valueOf(a);
    }
    public void reverse(char [] a,int start,int end){
    	int i=start;
    	int j=end;
    	char temp;
    	while(i<j){
    		temp=a[i];
    		a[i]=a[j];
    		a[j]=temp;
    		i++;
    		j--;
    	}
    }
    /*
     * 对于一个字符串，请设计一个算法，
     * 将字符串的长度为len的前缀平移到字符串的最后。
     * 给定一个字符串A和它的长度，同时给定len，
     * 请返回平移后的字符串。
     * 测试样例：
     * "ABCDE",5,3
     * 返回："DEABC"
     */
    public String stringTranslation(String A, int n, int len) {
    	//三步翻转法
    	char[] a=A.toCharArray();
       reverse(a, 0, len-1);
       reverse(a, len, n-1);
       reverse(a, 0, n-1);
       return String.valueOf(a);
       
    }
    @Test
    public void test(){
    String A="dog loves pig";
    System.out.println(reverseSentence(A, 13));
 }  
}
