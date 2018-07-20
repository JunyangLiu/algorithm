package 剑指offer;

import org.junit.Test;
/*
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，
 * 当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution_02 {
    public String replaceSpace(StringBuffer str) {
    	char[] s=str.toString().toCharArray();
    	int count=0;
    	for(int i=0;i<s.length;i++){
    		if(s[i]==' '){
    			count++;
    		}   		
    	}
    	char[] newStr=new char[s.length+count*2];
    	int j=newStr.length-1;
     	for(int i=s.length-1;i>=0;i--){
    		if(s[i]==' '){
    			newStr[j]='0';
    			newStr[j-1]='2';
    			newStr[j-2]='%';
    			j-=3;
    		}else{
    			newStr[j]=s[i];
    			j--;
    		}   		
    	}
     	return String.valueOf(newStr);
    }
    @Test 
	   public void test(){
		
		   System.out.println(replaceSpace(new StringBuffer("we are happy")));
	   }
}
