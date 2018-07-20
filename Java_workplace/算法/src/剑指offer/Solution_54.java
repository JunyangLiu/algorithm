package 剑指offer;

public class Solution_54 {
/*请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，
 * 第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
*/
	int hash[]=new int[122];
	  StringBuffer s=new StringBuffer();
    public void Insert(char ch)
    {
        hash[ch]++;
        s.append(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {	
    	char result='#';
    	for(char c:s.toString().toCharArray()){
    		if(hash[c]==1){
    			return c;
    		}
    	}
    	return result;
    }
}
