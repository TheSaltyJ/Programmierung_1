/* ************************************************************************* *\
*                Jonas Gehrlein (15-127-541) & Jan Dietrich (10-100-436)        * 
\* ************************************************************************* */

import java.text.DecimalFormat;
import java.util.Random;

public class RandomISBN
{

	public static void main( String args[] )
	{
		// TODO: Insert your code here!
		String ISBN1, ISBN2, ISBN3;
		ISBN1 = makeISBN();
		ISBN2 = makeISBN();
		ISBN3 = makeISBN();
		
		System.out.println("1st ISBN: " + ISBN1);
		System.out.println("2nd ISBN: " + ISBN2);
		System.out.println("3rd ISBN: " + ISBN3);
		
	

	}

/** generates and returns a random ISBN in the format XX-XXX-XX-C */
	public static String makeISBN()
	{
		// Do NOT change the declaration of the following variables!
		String laendercode;
		String bandnr;
		String verlagsnr;
		String checksum;
		String l_one_string, l_two_string, v_one_string, v_two_string, b_one_string, b_two_string, b_three_string;
		int l, v, b, c, l_one, l_two, b_one, b_two, b_three, v_one, v_two;
		Random generator = new Random ();
		l = generator.nextInt(99) + 1; // Random number between 1 - 99
		v = generator.nextInt(99) + 1; // Random number between 1 - 99
		b = generator.nextInt(900) + 100; // Random number between 100 - 999
				
		// TODO: Insert your code here!
		// Convert the random numbers to have also single digit numbers as two digits. E.g. 5 will be 05
		DecimalFormat fmt = new DecimalFormat("00");
		DecimalFormat fmt_one = new DecimalFormat("0");
		laendercode = fmt.format(l);
		bandnr = fmt.format(b);
		verlagsnr = fmt.format(v);
		// Parse out the different single digits from the whole number
		l_one_string = laendercode.substring(0,1);
		l_two_string = laendercode.substring(1,2);
		v_one_string = verlagsnr.substring(0,1);
		v_two_string = verlagsnr.substring(1,2);
		b_one_string = bandnr.substring(0,1);
		b_two_string = bandnr.substring(1,2);
		b_three_string = bandnr.substring(2,3);
		// Convert single digit strings to int
		l_one = Integer.parseInt(l_one_string);
		l_two = Integer.parseInt(l_two_string);
		v_one = Integer.parseInt(v_one_string);
		v_two = Integer.parseInt(v_two_string);
		b_one = Integer.parseInt(b_one_string);
		b_two = Integer.parseInt(b_two_string);
		b_three = Integer.parseInt(b_three_string);
		
		c = (hashOp(l_one) + l_two + hashOp(b_one) + b_two + hashOp(b_three) + v_one + hashOp(v_two)) % 10; 
		checksum = fmt_one.format(c);
		//Do not change the following line
		return laendercode + "-" + bandnr + "-" + verlagsnr + "-" + checksum;
	}
	
	/** multiplies i with 2 and subtracts 9 if result is >= 10 */
	public static int hashOp(int i)
	{
		// Do NOT change this method!
		int doubled = 2 * i;
		if (doubled >= 10) {
			doubled = doubled - 9;
		}
		return doubled;
	}	
}
