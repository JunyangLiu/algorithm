package 队列和栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlideWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] slide(int[] arr, int n, int w) {
    	//维护一个队列，保证该队列头部元素值是，第i个元素所在窗口的最大值
    	Deque<Integer> q=new ArrayDeque<>();
    	int[] result=new int [n-w+1];
    	int ri=0;
        for(int i=0;i<n;i++){
        	//检验队列头部元素是否过期，如果过期则弹出
        	while (!q.isEmpty() && q.peek() < i - w + 1) {
				q.poll();
			}
        	while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
				q.pollLast();
			}
        	q.offer(i);
			if (i >= w- 1) {
				result[ri++] = arr[q.peek()];
			}
        	}
        return result;
        }
    }

