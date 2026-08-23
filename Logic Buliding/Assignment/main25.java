import java.util.*;
class main25{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	System.out.print("Enter a string: ");
	String str = sc.nextLine();

	int count=0;
	for(int i=0;i < str.length();i++){
		  if(str.charAt(i) == 'a' || 
                 str.charAt(i) == 'e' || 
                  str.charAt(i) == 'i' || 
                   str.charAt(i) == 'o' || 
                    str.charAt(i) == 'u') {

            count++;
         }
        }

        System.out.println("The number of vowels in '" + str + "' is: " + count);

	}
}