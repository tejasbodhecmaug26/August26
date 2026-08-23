import java.util.*;
public class main{
	static int sumOfNumber(int a, int b){
		return(a + b);
		}
       public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("enter first number");
		int num1 = sc.nextInt();
		
		System.out.println("enter second number");
		int num2 = sc.nextInt();

		int result =sumOfNumber(num1 , num2);

		System.out.println("the sum of "+num1+" and "+num2+" is "+result );
		}
}
