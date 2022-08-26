package javaprojectpractice;

public class Thisclassdemo {

	int i=2;
	int j = 3;
	
	public static void main(String[] args) {
		/*
		 * Thisclassdemo p = new Thisclassdemo(); p.add();
		 */
		
		new Thisclassdemo().add(4, 5);
	}
	public void add(int i, int j) {
		Thisclassdemo p = new Thisclassdemo();
		System.out.println(i+j);
		System.out.println(this.i + this.j);
		//System.out.println(p.i+p.j);
	}
	
	public Thisclassdemo add1(int i , int j ) {
		System.out.println(this.i + this.j);
		return this;
	}
}
