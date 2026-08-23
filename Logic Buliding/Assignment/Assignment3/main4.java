import java.util.*;
public class main4{
	static void askForPositiveNumber(){

	Scanner sc = new Scanner(System.in);
        int number;
	do{
		System.out.println("enter positive number: ");
	        number = sc.nextInt();
	  }while(number <=0);
		System.out.println("you entired positive number: "+number);
}

	public static void main(String[] args){
		askForPositiveNumber();
	}

}