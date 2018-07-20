package 剑指offer;

import java.util.Stack;

public class Solution_19 {
/*
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈最小元素的min函数。
 */

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
        	minStack.push(node);
        }else{
        	if (node<minStack.peek()) {
				minStack.push(node);
			}else{
				minStack.push(minStack.peek());
			}
        }
    }
    
    public void pop() {
    	if(!stack.isEmpty()&&!minStack.isEmpty()){
            stack.pop();
            minStack.pop();
    	}else{
    		return;
    	}

    }
    
    public int top() {
    	if(!stack.isEmpty()){
            return stack.peek();
    	}else{
        	return -1;
    	}

    }
    
    public int min() {
    	if(!minStack.isEmpty()){
            return minStack.peek();
    	}else{
        	return -1;
    	}
    }
}
