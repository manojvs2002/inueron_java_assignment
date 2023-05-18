package javaAssignment1;

import java.util.Scanner;

public class Exceptionexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter an Integer");
		int a = sc.nextInt();
		
		try {
			if(a < 0) {
				throw new Exception("not a positive number");
				
			}else
			{
				System.out.println("enetred number"+a+"is a positive integer");
				
			}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				
			}
		
	
}

}
/*the above program exolains about the exception handling
 * the code takes an input from the user as a Integer
 * checks whether the Integer enetred is +ve or -ve
 * using try catch keywords we throw an exception if entered no is less than 0 then it is a negative number else
 * it is a positive number*/
 