package 队列和栈;

import java.util.Stack;

public class ReversStack {
	/*
	 * 题目：
	 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，
	 * 而不能自己申请另外的数据结构。
	 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
	 * 测试样例：
	 * [4,3,2,1],4
	 * 返回：[1,2,3,4]
	 */
	
    public int[] reverseStack(int[] A, int n) {
    	Stack< Integer> stack=new Stack<>();
    	for(int i=0;i<n;i++){
    		stack.push(A[i]);
    	}
    	revers(stack);
    	for(int i=0;i<n;i++){
    		A[i]=stack.get(i);
    	}
       return A;
    }
    //获取栈底元素的递归函数
    public int getLast(Stack<Integer> stack) {
		int result=stack.pop();
		if(stack.isEmpty()){
			return result;
		}
		int last=getLast(stack);
		stack.push(result);
		return last;
	}
    public void revers(Stack<Integer> stack){
    	if(stack.isEmpty()){
    		return;
    	}
    	int i=getLast(stack);
    	revers(stack);
    	stack.push(i);
    }
}
