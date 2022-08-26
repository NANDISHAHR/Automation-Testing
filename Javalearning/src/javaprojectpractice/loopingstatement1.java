package javaprojectpractice;

public class loopingstatement1 {
public static void main(String[] args) {
	int i;
	for(i=1;i<=10;i++)
	{
		System.out.println(i);
	}
	
	int[] arr1 = {1,2,3,4,5};
	for(int j=0 ; j < arr1.length; j++) {
		System.out.println(arr1[j]);
	}


	for(int k = arr1.length-1; k >=0; k--)
	{
		System.out.println(arr1[k]);
	}
	
	int arr2[] = {5,10,15,20,25};
	for(int element : arr2) {
		System.out.println(element);
	}
}

}
