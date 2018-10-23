public class MyTransactions
{

	public static void main(String[] args)
	{
		MyAccount account1 = new MyAccount(1, "Peter Hans", 3000);
		MyAccount account2 = new MyAccount(2, "Hans Jürgen", 1000);
		
		account1.getBalance();
		account2.getBalance();
		
		System.out.println(account1);
		System.out.println(account2);
		
		account1.toString();
		account2.toString();
		
		System.out.println(account1);
		System.out.println(account2);
		
		
		
	}
		
		

}

	