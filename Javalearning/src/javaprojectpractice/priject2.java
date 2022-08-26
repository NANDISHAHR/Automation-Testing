package javaprojectpractice;

import java.util.Scanner;

public class priject2 {

	
	public static void main(String[] args) {
		/*
		 * int i = 10; System.out.println(i);
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("what is your name ");
		
		String name = sc.nextLine();
		System.out.println("Hellow " +name);
		System.out.println("what is your age");
		int age = sc.nextInt();
		System.out.println("Your age is "+age);
		sc.close();
	}
	
}
