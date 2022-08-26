package javaprojectpractice;

public class Classdemo {

	int noofgears;
	String color ;
	
	public Classdemo() {
		//code
		
		color = "Black";
	}
	
	public Classdemo(String color) {
		
		this.color = color;
	}
	
	public Classdemo (int noofgears ) {
		
		this.noofgears = noofgears;
	}
	public  void Increasedaccesllation(int speed){

		System.out.println("The accesleration is incread by "+speed);
		
	}
	public String getcolour() {
		return color;
	}
	
	public void setcolor(String color) {
		this.color = color;
	}
	
}
