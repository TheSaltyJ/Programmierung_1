/* ************************************************************************* *\
*                Programmierung 1 HS 2018 - Serie 3-1                         * 
\* ************************************************************************* */

import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class Book
{
	private int id;
	private String title;
	private String author;
	private Date dateOfPublication;
	
	// Initialize variables
	// Scanner Variables
	int scn_id;
	String scn_title, scn_author;
	String scn_date;
	// Other Variables
	int days_since_publication;
	
	public static final String DATE_FORMAT = "dd.MM.yyyy";

	//--- constructors ---
	// TODO: Insert your code here!
	public Book (int id_input,String title_input, String author_input, String date_input)
	{
		id = id_input;
		title = title_input;
		author = author_input;
		dateOfPublication = stringToDate(date_input);
	}


	/** Returns the age of the book in days since publication */
	public int age()
	{
		// TODO: Insert your code here!
		Date date_today = new Date(); // Initiates a Date object..

		// Returns the time passed in ms from the epoch year until today.
		long ms_since_epoch_to_today = date_today.getTime();

		// Calculates the days of publication from the epoch year.
		long ms_since_epoch_to_publication = dateOfPublication.getTime();
		
		// Calculates the days from the publication until today which is the difference between the days from the epoch year until today and the days between publication and epoch year.
		long days_since_publication_to_today = (ms_since_epoch_to_today - ms_since_epoch_to_publication) / 86400000L;
		
		// Passes the value of the long variable to an int variable to match the return type of the method.
		days_since_publication = (int) days_since_publication_to_today;
				
		return days_since_publication;
	}

	/** Returns a String representation of the book */
	public String toString()
	{
		return (id + ", " + title + ", " +  author + ", " +  dateToString(dateOfPublication));
	}

	/** Reads all book data from user input */
	public void input() 
	{
		// TODO: Insert your code here!
		Scanner user_input = new Scanner( System.in );
		System.out.print( "Please enter id: " );
		id = user_input.nextInt();

		System.out.print( "Please enter author: " );
		author = user_input.next();
		
		System.out.print( "Please enter title: " );
		title = user_input.next();

		System.out.print( "Please enter date of publication: " );
		dateOfPublication = stringToDate(user_input.next());
	}

	//----Set-methods ---
	public int setID(int scn_id)
	{
		id = scn_id;
		return id;
	}
	
	public String setAuthor(String scn_author)
	{
		author = scn_author;
		return author;
	}
	
	public String setTitle(String scn_title)
	{
		title = scn_title;
		return title;
	}
	
	public Date setDate(String scn_date)
	{
		dateOfPublication = stringToDate(scn_date);

		return dateOfPublication;
	}

	//--- Get-methods/-------
	public int getID()
	{
		return id;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public Date getDate()
	{
		return dateOfPublication;
	}

	// TODO: Insert your code here!

	//--- helper methods -- DO NOT CHANGE ------------------------------------
	/** Converts the Date object d into a String object */
	public static String dateToString( Date d )
	{
		SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
		return fmt.format( d );
	}

	/** Converts the String object s into a Date object */
	public static Date stringToDate( String s ) 
	{
		Date r = null;
		try {
			SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
			r = fmt.parse( s );
		} catch ( ParseException e ){
			System.err.println( e );
			System.exit(1);
		}
		return r;
	}
}
