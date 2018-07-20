package 剑指offer;

import org.junit.Test;

public class Solution_44 {
/*
 * 牛客最近来了一个新员工Fish，
 * 每天早晨总是会拿着一本英文杂志
 * ，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
    public String ReverseSentence(String str) {
    	if(str==null||str==""){
    		return "";
    	}
        char[] s=str.toCharArray();
        int pre=0;//之前的字母出现的位置
        int i=0;
        for(;i<s.length;i++){
        	if(s[i]==' '){
        		revers(s, pre,i-1);
        		pre=i+1;
        	}
        }
        revers(s, pre,i-1);
        revers(s, 0,s.length-1);
        return String.valueOf(s);
    }
    public void revers(char[] s,int start,int end){
    	while(start<end){
    		char temp=s[start];
    		s[start]=s[end];
    		s[end]=temp;
    		start++;
    		end--;
    	}
    }
    @Test
    public void test(){
   	 System.out.println(ReverseSentence("student am I"));
    }
}
