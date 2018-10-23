// Jonas Gehrlein 15-127-541 & Jan Dietrich 10-100-436

import java.util.Scanner;

public class Divide 
{	
	public static void main(String[] args)
	{
		float x;
		float y;
		float float_solution;
		int integer_solution;
		float remainder;
		Scanner scan = new Scanner(System.in);
		System.out.print("This program will calculate the expression (a * a)/b where a is your first input and b your second");
		System.out.print("\nEnter an integer for a: ");
		x = scan.nextInt();
		System.out.print("Enter another integer for b: ");
		y = scan.nextInt();
		float_solution = x * x / y;
		remainder = (x * x) % y;
		integer_solution = (int) float_solution;
		System.out.println("The solution as float variable is "+ float_solution + "");
		System.out.println("The solution as integer variable is "+ integer_solution + " with remainder " + remainder + "");
	
	}
}
		