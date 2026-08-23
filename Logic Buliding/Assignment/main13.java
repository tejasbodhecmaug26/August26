import java.util.*;

class main13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        	int[] arr = new int[5];

        System.out.println("Enter 5 integers: ");

        	for (int i = 0; i < 5; i++) {
            		arr[i] = sc.nextInt();
        }

        System.out.println("Enter a number to search:  "); 
	int num =sc.nextInt();       
	  for (int i = 0; i < 5; i++) {
            if(arr[i] == num){
		System.out.println("Found"); 
		return;
		} 
		}
		System.out.println("Not Found");
		
     }
   }
