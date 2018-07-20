package string;

import org.junit.Test;

public class StringTest {
    public String replaceSpace(String iniString, int length) {
        char[] str = iniString.toCharArray();
        int count = 0;
        for(int i=0;i<length;i++){
            if(str[i]==' '){
                count++;
            }
        }
        char[] str2 = new char[length+count*2];
        int j=0;
        for(int i=0;i<length;i++){
        	if(str[i]!=' '){
        		str2[j]=str[i];
        	}else{
        		  str2[j]='%';
                  str2[j+1]='2';
                  str2[j+2]='0';
                  j+=3;
        	}
        }
        return String.valueOf(str2);
    }
    /*
     * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
     * 给定一个字符串A和它的长度n，
     * 请返回一个bool值代表它是否为一个合法的括号串。
     */
    public boolean chkParenthesis(String A, int n) {
    	char[] a=A.toCharArray();
    	int num=0;
    	int i=0;
    	while(i<n&&num>=0){
    		if(a[i]=='('){
    			num++;
    		}else if(a[i]==')'){
    			num--;
    		}
    		i++;
    	}
    	if(num!=0){
    		return false;
    	}else{
    		return true;
    	}
    }
  
    /*
     * 对于一个给定的字符串数组，请找到一种拼接顺序，
     * 使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
     * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
     */
    //解析：就是把字符串排序后重新拼接
//    public String findSmallest(String[] strs, int n) {
//        // write code here
//    }
    
  /*
   * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
   * 给定一个字符串A及它的长度n，
   * 请返回它的最长无重复字符子串长度。
   * 保证A中字符全部为小写英文字符，且长度小于等于500。
   * 测试样例：
   * "aabcb",5
   * 返回：3
   */
    public int longestSubstring(String A, int n) {
    	if(A==null||n==0){
    		return 0;
    	}
       char[] a=A.toCharArray();
       int[] map=new int[256];
       for(int i=0;i<256;i++){
    	   map[i]=-1;
       }
       int length=0;
       int current=0;
       int pre=-1;//记录的是以第i-1位字符结尾的最长无重复子串的左边界
       for(int i=0;i<n;i++){
    	   pre=Math.max(pre, map[a[i]]);
    	   System.out.println(pre);
    	   current=i-pre;
    	   length=Math.max(current, length);
    	   map[a[i]]=i;
    	   
       }

    	return length;	   
    }
    
    @Test
    public void test(){
//    	String A="ab";
    	String A="rfr";
    	System.out.println(longestSubstring(A, 3));
 } 
}
