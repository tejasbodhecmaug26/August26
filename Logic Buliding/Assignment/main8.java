import java.util.*;

class main8{
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String[] arr=new String[4];

		System.out.println("Enter 4 names: ");
		for(int i=0;i<arr.length;i++){
		
		     arr[i]=sc.nextLine();
		} 
 
		for(String x : arr){
			System.out.print(" "+x); 			
		}
		
}
	}