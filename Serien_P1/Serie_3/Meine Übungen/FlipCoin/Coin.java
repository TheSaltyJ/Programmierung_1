import java.util.Random;


public class Coin
{
	private int faceValue = 0;
	private int timesFlipped = 0;
	private String faceLook;
	Random generator = new Random();
	
	public int CoinFlip()
	{
		faceValue = generator.nextInt(2);
		timesFlipped++;
		return faceValue;
	}
	
	public String LookAtCoin()
	{
		if (faceValue == 0)
			faceLook = "Head";
		else
			faceLook = "Tail";
		return faceLook;
	}
	
	public void TimesFlipped()
	{
		System.out.println("The coin has been flipped" + timesFlipped + "times");		
	}
	 
}

		