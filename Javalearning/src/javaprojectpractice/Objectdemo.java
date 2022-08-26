package javaprojectpractice;

public class Objectdemo {

	public static void main(String[] args) {
		Classdemo Bike = new Classdemo();
		Bike.setcolor("Red");
		System.out.println(Bike.getcolour());
		System.out.println("Bike color - " +Bike.getcolour() );
		
		Classdemo Bike1 = new Classdemo();
		System.out.println("bike color " +Bike1.getcolour());
	
		
	}
}
