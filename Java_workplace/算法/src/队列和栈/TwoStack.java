package 队列和栈;

import java.util.Stack;

public class TwoStack {
	/*
	 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
	 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，
	 * 为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
	 * 测试样例：
	 * [1,2,3,0,4,0],6
	 * 返回：[1,2]
	 */
private Stack<Integer> stack1=new Stack<>();
private Stack<Integer> stack2=new Stack<>();
public int pop(){
    
    if(stack2.isEmpty()){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
         
    }
    else{
        return stack2.pop();
    }
}
public void push(int num){
	 stack1.push(num);
}
public int[] twoStack(int[] ope, int n) {
	 int index=0;
	 for(int i=0;i<n;i++){         
         if(ope[i]>0){
             push(ope[i]);
         }
         else if(ope[i]==0){
             ope[index] = pop();
             index++;
         }
     }
	  int[] result = new int[index];
      for(int i=0;i<index;i++){
          result[i] = ope[i];
      }
       
      return result;
}
}
