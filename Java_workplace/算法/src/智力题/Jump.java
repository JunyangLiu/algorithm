package 智力题;

import org.junit.Test;

public class Jump {
    public int checkWin(int n) {
 return (n-1) % 4 == 0 ? 0 : 1;
    }
@Test 
public void test(){
		for(int i=1;i<=10;i++){
			System.out.print(i+"： "+checkWin(i)+"     ");
		}
	   }
}
