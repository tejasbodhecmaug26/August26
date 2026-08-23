import java.util.*;

class main10{
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int[] arr=new int[5];

		System.out.print("Enter 5 integer: ");
		for(int i=0;i<arr.length;i++){
		
		     arr[i]=sc.nextInt();
		} 

		int sum=0;
		for(int x : arr){
			sum = sum +x;		
		}
		float average=(float) sum /5;	
		System.out.println("The average of the numbers is: " + average);
}
	}