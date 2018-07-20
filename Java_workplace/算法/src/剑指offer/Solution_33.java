package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Solution_33 {
	/*
	 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
	 * 例如6、8都是丑数，但14不是，因为它包含因子7。
	 *  习惯上我们把1当做是第一个丑数。
	 * 求按从小到大的顺序的第N个丑数。
	 */
    public int GetUglyNumber_Solution(int index) {
    	if(index<=0){
    		return 0;
    	}
    	if(index==1){
    		return 1;
    	}
    	Queue<Integer> q2=new LinkedList<>();
    	Queue<Integer> q3=new LinkedList<>();
    	Queue<Integer> q5=new LinkedList<>();
    	q2.offer(2);
    	q3.offer(3);
    	q5.offer(5);
    	int min=1;//表示三个队列中队列头部最小元素
    	int count=2;
    	while(count<=index){
    		min=Math.min(Math.min(q2.peek(), q3.peek()), q5.peek());
    		if(min==q2.peek())q2.poll();
    		if(min==q3.peek())q3.poll();
    		if(min==q5.peek())q5.poll();
    		q2.offer(min*2);
    		q3.offer(min*3);
    		q5.offer(min*5);
    		count++;
    	}
        return min;
    }
    @Test
    public void test(){
    	for(int i=1;i<=10;i++){
        	System.out.print(GetUglyNumber_Solution(i)+"  ");	
    	}

    }
}
