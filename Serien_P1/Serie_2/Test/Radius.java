import java.text.DecimalFormat;

public class Radius
{
	public static void main(String[] args)
	{
		
		double area;
		area = 5.3234;
		DecimalFormat fmt = new DecimalFormat("0.###"); // Create object fmt which is a DecimalFormat class object
		System.out.println("The circle area is" + fmt.format(area));
	}
}