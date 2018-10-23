import java.util.Date;
import java.text.*;

public class Time
{

	public static void main(String[] args)
	{
		String scn_date = "02.01.1970";
		int days_since_publication;
		
		// TODO: Insert your code here!
		Date date_today = new Date(); // Initiates a Date object..
		Date book_date = new Date(); // Initiates a Date object.

		// Returns the time passed in ms from the epoch year until today.
		long ms_since_epoch_to_today = date_today.getTime();

		// The date of publication is passed as String to the stringToDate Method to parse the data and return a Date object.
		book_date = stringToDate(scn_date);

		// Calculates the days of publication from the epoch year.
		long ms_since_epoch_to_publication = book_date.getTime();

		// Calculates the days from the publication until today which is the difference between the days from the epoch year until today and the days between publication and epoch year.
		long days_since_publication_to_today = (ms_since_epoch_to_today - ms_since_epoch_to_publication) / 86400000L;

		// Passes the value of the long variable to an int variable to match the return type of the method.
		days_since_publication = (int) days_since_publication_to_today;

		System.out.println(days_since_publication_to_today);
		System.out.println(days_since_publication);
	}
	
	public static Date stringToDate( String s ) 
	{
		Date r = null;
		try {
			SimpleDateFormat fmt = new SimpleDateFormat( "dd.MM.yyyy" );
			r = fmt.parse( s );
		} catch ( ParseException e ){
			System.err.println( e );
			System.exit(1);
		}
		return r;
	}
	
	
}
