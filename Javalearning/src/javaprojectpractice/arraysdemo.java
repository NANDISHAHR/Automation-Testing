package javaprojectpractice;

public class arraysdemo {

	public static void main(String[] args) {
	
		int EmployeeId = 101;
		String EmployeeName = "Nandish";
		
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		System.out.println(arr[4]);
		
		String[] arr1 = {"Nandish", "Abcd", "LMNC"};
		System.out.println(arr1[1]);
		
		int[][] twodimarr = new int[2][3];
		
		twodimarr[0][0] = 1;
		twodimarr[0][1] = 1;
		twodimarr[0][2] = 1;
		twodimarr[1][0] = 1;
		twodimarr[1][1] = 1;
		twodimarr[1][2] = 1;
		
		System.out.println(twodimarr[0][2]);
		String[][] arr2 = {{"a", "b"}, {"abcd", "6"}};
		System.out.println(arr2[0][0]);
		
		//jagged array
		int[][] jaggedArr = new int[2][];
		
		jaggedArr[0] = new int[2];
		jaggedArr[1] = new int[4];
		
		jaggedArr[0][0] = 1;
		jaggedArr[0][1] = 2;
		jaggedArr[1][0] = 3;
		jaggedArr[1][1] = 11;
		jaggedArr[1][2] = 12;
		jaggedArr[1][3] = 10;
		
		System.out.println(jaggedArr[1][3]);
		
		String[][] jaggedArr1 = {
				{"abc","bcd" ,"b"},
				{"abcd","nm"}
		};
		System.out.println(jaggedArr1[0][2]);

	}

}
