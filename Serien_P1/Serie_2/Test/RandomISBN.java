/* ************************************************************************* *\
*                Programmierung 1 HS 2018 - Serie 2 Aufgabe 1                 * 
\* ************************************************************************* */

import java.text.DecimalFormat;
import java.util.Random;

public class RandomISBN
{

	public static void main( String args[] )
	{
		int c, b;
		c = 5 ;
		b = c.hashOp();
		
		
	}
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
