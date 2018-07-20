package 面试题;



public class Test {

	public static void main(String[] args) {
		B b=new B();
		b.p();
		A a=(A)b;
		a.p();

	}
}
class A {
	public void p(){
      System.out.println("A");
}
}
	class B extends A{
		public void p(){
	      System.out.println("B");
	}
}