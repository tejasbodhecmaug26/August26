import java.util.*;

class main14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        	int[] arr = new int[5];

        System.out.println("Enter 5 integers: ");

        	for (int i = 0; i < 5; i++) {
            		arr[i] = sc.nextInt();
        }

	Arrays.sort(arr);
        System.out.println("Enter a number to search:  "); 
		int num =sc.nextInt(); 

		int index = Arrays.binarySearch(arr,num);      
	     if(index>=0){
			System.out.println("the number "+num+" is found at index "+index); 
		}else{
		System.out.println("Not Found");
	}
		
     }
   }
