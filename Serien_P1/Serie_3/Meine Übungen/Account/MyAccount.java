import java.text.NumberFormat;


public class MyAccount
{
	private long accNr;
	private String name;
	private double balance;
	
	// Constructor
	public MyAccount (long number, String owner, double initial) // This here is how the input comes into the class
	{
		accNr = number;
		name = owner;
		balance = initial;
	}
	
	// Let's do some methods to interact with the methods
	
	public double deposit (double amount)
	{
		balance = balance + amount;
		return balance;
	
	}
	
	public double withdraw (double amount, double fee)
	{
		balance = balance - amount - fee;
		return balance;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		return (accNr + "\t" + name + "\t" + fmt.format(balance)); 
	}
}
