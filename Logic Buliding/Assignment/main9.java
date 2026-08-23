import java.util.*;

class main9{
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int[] arr=new int[5];

		System.out.println("Enter 5 integer: ");
		for(int i=0;i<arr.length;i++){
		
		     arr[i]=sc.nextInt();
		} 

		  int largest=arr[0];
		  for(int x: arr){
			if(x > largest){
			largest=x;
			}
		   }
	System.out.print("largest number is: " +largest);
	
}
	}