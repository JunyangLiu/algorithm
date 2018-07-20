package boject;
//父类
class Father{
	//父类的静态成员函数
    public static void printValue() {  
        System.out.println("father");  
    } 
}

//子类
class Child extends Father {
	//子类的静态成员函数
	public  static void printValue() {  
		  System.out.println("child"); 

		} 
}

public class Test {
	public static void main(String[] args) {
		Father father=new Father();
		Father child=new Child();
	   father.printValue();
	   child.printValue();	
	}
}

