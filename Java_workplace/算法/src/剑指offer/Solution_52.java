package 剑指offer;

import java.util.regex.Matcher;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;

public class Solution_52 {
	/*
	 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
	 * 模式中的字符'.'表示任意一个字符，
	 * 而'*'表示它前面的字符可以出现任意次
	 * （包含0次）。 在本题中，
	 * 匹配是指字符串的所有字符匹配整个模式。
	 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
	 * 但是与"aa.a"和"ab*a"均不匹配
	 */
/*
 * 
 * 思路：当模式中的第二个字符不是“*”时：
1、如果字符串第一个字符和模式中的第一个字符相匹配，
那么字符串和模式都后移一个字符，然后匹配剩余的。
2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

而当模式中的第二个字符是“*”时：
如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，
继续匹配。如果字符串第一个字符跟模式第一个字符匹配，
可以有3种匹配方式：
1、模式后移2字符，相当于x*被忽略；
2、字符串后移1字符，模式后移2字符；
3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 */
		public boolean match(char[] str, char[] pattern)
		    {
			 if (str == null || pattern == null) {
			        return false;
			    }
		       return machTwo(str, pattern, 0, 0);
		         
		    }
		public boolean machTwo(char[] str, char[] pattern,int strStart,int parStart){
			System.out.println(strStart+" "+parStart);
			if(strStart==str.length&&parStart==pattern.length){
				return true;
			}
			if(strStart!=str.length&&parStart==pattern.length){
				return false;
			}

			if(parStart+1<pattern.length&&pattern[parStart+1]=='*'){
				if(strStart!=str.length&&(str[strStart]==pattern[parStart]||pattern[parStart]=='.'))
				{
					return machTwo(str, pattern, strStart, parStart+2)
							||machTwo(str, pattern, strStart+1, parStart+2)
							||machTwo(str, pattern, strStart+1, parStart);
				}else{
					return machTwo(str, pattern, strStart, parStart+2);
				}
		
			}
			if(strStart<str.length&&(pattern[parStart]==str[strStart]||pattern[parStart]=='.')){
				return machTwo(str, pattern, strStart+1, parStart+1);
			}
			return false;
		}
	

	@Test
	public void test(){
		char[] a="45".toCharArray();
		System.out.println(a[0]);
	}
}
