import java.util.*;
public class main5{
	static void printMultiplicationTable(int number){
		 for(int i=1;i<=10;i++){
		System.out.println(number+" * "+i+" = "+(number*i));
		}

		}
       public static void main(String[] args){
		 Scanner sc = new Scanner(System.in);

                 System.out.print("Enter a number: ");
                 int number = sc.nextInt();
		 printMultiplicationTable(number);
		}
}
