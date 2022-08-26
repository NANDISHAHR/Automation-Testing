package javaprojectpractice;

public class Decissionmakingstatement {

	public static void main(String[] args) {
		int a = 6;
		int b  = 2;
		if(a==b) {
			System.out.println("The a is equal to b");
		}
		else if(a > 1) {
			System.out.println("The a is gretaer than equal to 1");
		}
		else
		{
			
			System.out.println("a is not equal to b");
		}
		
		int C = 3;
		switch(C) {
		case 1 :
			System.out.println("1");
			break;
		case 2 :
			System.out.println("2");
			break;
		case 3 :
			System.out.println("3");
			break;
			default :
				System.out.println("inavlid number");
		}
	}
}
