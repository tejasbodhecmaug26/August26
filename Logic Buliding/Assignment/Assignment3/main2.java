import java.util.*;
public class main2{
	static int checkAgeCategory(int age){
		if(age >= 60){
		System.out.println("you are an senior citizen");
		}else if(age >= 18){
		System.out.println("you are an adult");
		}else {
		System.out.println("you are an minor");
		}
		return age;
		}
       public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("enter your age: ");
		int Age = sc.nextInt();
		
		checkAgeCategory(Age);
		 
		 
		}
}
