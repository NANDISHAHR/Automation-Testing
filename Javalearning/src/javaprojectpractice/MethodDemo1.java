package javaprojectpractice;

public class MethodDemo1 {

	public static void main(String[] args) {
		sayhello();
		sayhello();
		sayhello();
		greet("John");
		int result = add(2, 4);
		System.out.println(result);
	}
	
	//example1
	
	public static void sayhello() {
		System.out.println("Hellow");
	}
	
	//example2 with params
	
	public static void greet(String name) {
		System.out.println("Hellow "+name);
	}
	
	//eample 3 paras and return value
	
	public static int add(int i , int j) {
		int k= i+j;
		return k;
	}
}
