public class FlipCoin
{
	public static void main(String[] args)
	{
	Coin flip1;
	String result;
	flip1 = new Coin();
	int count = 0;
	int count_tail = 0;
	int count_head = 0;
	double ratio;
	
	
	while (count <= 10000)
	{
		flip1.CoinFlip();
		result = flip1.LookAtCoin();
		count++;
		if (result == "Head")
			count_head++;
		else
			count_tail++;
	
	
	}
	ratio = (double) count_head / count_tail;
	
	System.out.println(count_head);
	System.out.println(count_tail);
	System.out.println(ratio);
	
	}
	
}