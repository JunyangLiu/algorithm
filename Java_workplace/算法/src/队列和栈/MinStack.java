package 队列和栈;
import java.util.Stack;
public class MinStack {
	/*
	 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。	
	 */
	private Stack<Integer> stack=new Stack<>();
	private Stack<Integer> minStack=new Stack<>();
	private int min=0;
	   public void push(int node) {
	        stack.push(node);
	        if(minStack.isEmpty()){
	        	minStack.push(node);
	        	min=node;
	        }else if(node<min){
	        	minStack.push(node);
	        	min=node;
	        }else{
	        	minStack.push(min);
	        }
	    }
	    
	    public void pop() {
	        stack.pop();
	        minStack.pop();
	    }
	    
	    public int top() {
	        return stack.peek();

	    }
	    
	    public int min() {
	        return minStack.peek();
	    }
}
