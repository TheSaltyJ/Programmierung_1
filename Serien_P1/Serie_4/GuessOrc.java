/* ************************************************************************* *\
*                Programmierung 1 HS 2018 - Serie 4-1                         *
*		Jonas Gehrlein (15-127-541) & Jan Dietrich (10-100-436)	      *
\* ************************************************************************* */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessOrc {

	// Stores the input of the user
	public String input_user;
	public Scanner scn = new Scanner(System.in);
	boolean input_user_is_correct = false;
	// Converts user input to char.
	public char input_user_as_char;
	//Mineshaft ID guessed by user
	public int guessedMineShaftID;
	public int hint_ID;
	// Game runs as long as the player has not won or MAX_Attemps is not reached
	boolean stopGame = false;
	// Store the orc chieftain position.
	private int mineShaftId;
	//Start with Round 1
	public int current_round = 1;
	// Amount of attempts we get to stop the orcs.
	// Use 'MAX_ATTEMPTS'' instead of coding a number
	// directly into your program.
	public final int MAX_ATTEMPTS = 6;
	// Randomizer variable to randomize between potential HINTS.
	Random randomizer = new Random();
	// Calculates the distance between the guess and the real location. If Distance > 0 then the orcs are
	// to the left and if < 0 then to the right.
	int distance_to_orcs;
	// Creates an array with potential HINT messages from which one will be randomly selected
	ArrayList<String> potential_hints = new ArrayList<String>();
	// Number of mine shafts from which orcs can arrive.
	public final int MINE_SHAFTS = 12;

	// Magic numbers to tell us when something was not set.
	public final int NO_MOVE_MADE = -1;
	public final int NO_HINT = -1;

	// Could not parse the given input.
	public final int PARSING_FAILED = -1;

	// SET DEBUG MODE.
	public final boolean DEBUG = false;

	// That's what the orc horde looks like.
	public final String ORCS =  "  ┗(｀Дﾟ┗(｀ﾟДﾟ´)┛ﾟД´)┛  ";
	// If you use WINDOWS (or the above line just looks wrong) change it to this:
	//public final String ORCS =  "  - - - ORC--ARMY - - -  ";

	//Do not modify or access!
	private int[] history = new int[ MAX_ATTEMPTS ];
	private int[] historyHelpers = new int[ MAX_ATTEMPTS ];

	private final String[] HINTS = new String[] {
			"to the left",
			"to the right",
			"under dirt",
			"under stone",
			"very far away"
	};

	// DO NOT CHANGE THIS METHOD!
	public static void main ( String[] args ) {
		GuessOrc game = new GuessOrc();
		game.resetHistory();
		game.start();

	}

	/**
	 * Implement your hint calculation here.
	 *
	 * @param guessedMineShaftId the guessed mine shaft.
	 * @return the id for a hint in HINT.
	 */
		public int calculateHint( int guessedMineShaftId ) {
			// Reset the array each round
			potential_hints.clear();
			// Calculates the distance from the guess towards the real location. The sign of the value indicates
			// left and right and the stone/dirt location is only dependant on the current round and the far away
			// message can be calculated with the absolute distance.
			distance_to_orcs = mineShaftId - guessedMineShaftId;

			// Finding all potential HINTS.
			// Checking whether there is stone. If the Position of the Horde (ShaftID+Amount of Moves) is even number
			// the orcs are under a rock.
			if ((mineShaftId + (current_round-1)) % 2 == 0) {
				potential_hints.add("3"); // Adds index of HINTS of being under stone
				}
				else {
					potential_hints.add("2");
			}

			if (distance_to_orcs > 0){
				potential_hints.add("1"); // Adds index of HINTS of being to the right
				}

			if (Math.abs(distance_to_orcs) > 5){
				potential_hints.add("4"); // Adds index of HINTS of being far away
				}

			if (distance_to_orcs < 0){
				potential_hints.add("0"); // Adds index of HINTS of being to the left
				}

			// TODO: Add checker if under dirt.
			// Checks how many HINTS are in the Array.
			int size_of_potential_hint_array = potential_hints.size();
			// Randomizes for the index of all the potential Hints in the Array
			int random_hint = randomizer.nextInt(size_of_potential_hint_array);
			// Extracts the randomly chosen HINT from the Potential HINTS and converts to INT.
			int randomized_hint = Integer.parseInt(potential_hints.get(random_hint));

		return randomized_hint;
	}

	/**
	 * Implement the game logic here.
	 */
	public void start() {
		// Your code goes here
		// A new location for the orc horde will be guessed between shaft 1 and 11.
		Random generator = new Random();
		mineShaftId = generator.nextInt(11) + 1;
		// The first round will be initialized and then the loop starts.
		System.out.println(generateOrcIntroScreen());
		// Initialize the first round with no_move made and no_hint.
		hint_ID = NO_HINT;
		guessedMineShaftID = NO_MOVE_MADE;
		//TODO: Problem here! What should be the parameter of printMap?
		do {
			printMap(guessedMineShaftID, hint_ID);
			if (current_round == 1)
				System.out.println("Please enter your first guess: ");
			else
				System.out.println("Next guess? ");
			input_user = scn.next();
			input_user_is_correct = checkInput(input_user);
			// This methods checks whether the input of the user is correct
			// and then loops for the case that the user does not input something correct.
			while (input_user_is_correct == false) {
				System.out.println("Your input was not correct. Please try again");
				input_user = scn.next();
				input_user_is_correct = checkInput(input_user);
			}
			// converts the string to char
			input_user_as_char = input_user.charAt(0);
			guessedMineShaftID = getColumnAsInt(input_user_as_char);
			// check if game should be stopped
			stopGame();

			if (stopGame == false)
				hint_ID = calculateHint(guessedMineShaftID);

			current_round++;

		} while (stopGame == false);


	}

	private boolean stopGame(){
		// This method checks whether the game should continue or not.
		stopGame = false;
		if (guessedMineShaftID == mineShaftId & current_round < MAX_ATTEMPTS) {
			stopGame = true;
			System.out.println("You win!");
		}
		if (current_round == MAX_ATTEMPTS) {
			stopGame = true;
			System.out.println("You lose! The orcs attacked from mine shaft '" + getMineShaftAsChar(mineShaftId) + "'");
		}
		return stopGame;


	}

	public boolean checkInput(String x){
		x = x.toLowerCase();
		switch ( x )
		{
			case "a":
				input_user_as_char = 'a';
				return true;
			case "b":
				input_user_as_char = 'b';
				return true;
			case "c":
				input_user_as_char = 'c';
				return true;
			case "d":
				input_user_as_char = 'd';
				return true;
			case "e":
				input_user_as_char = 'e';
				return true;
			case "f":
				input_user_as_char = 'f';
				return true;
			case "g":
				input_user_as_char = 'g';
				return true;
			case "h":
				input_user_as_char = 'h';
				return true;
			case "i":
				input_user_as_char = 'i';
				return true;
			case "j":
				input_user_as_char = 'j';
				return true;
			case "k":
				input_user_as_char = 'k';
				return true;
			case "l":
				input_user_as_char = 'l';
				return true;
			default:
				return false;
		}
	}


	// --- Helper methods ---

	/**
	 * Resets the game's history.
	 * 
	 * DO NOT CHANGE THIS METHOD!
	 */
	private void resetHistory() {
		history = new int[ MAX_ATTEMPTS ];
		Arrays.fill( history, NO_MOVE_MADE );
		historyHelpers = new int[ MAX_ATTEMPTS ];
		Arrays.fill( historyHelpers, NO_HINT );
	}

	/**
	 * Calculates the number of moves.
	 * 
	 * @return the number of moves already made.
	 * 
	 * DO NOT CHANGE THIS METHOD!
	 */
	private int movesMade() {
		int currentMove = 0;
		while (currentMove < MAX_ATTEMPTS && history[currentMove] != NO_MOVE_MADE){
			currentMove++;
		}
		return currentMove;
	}

	/**
	 * Prints the map.
	 * If you hand it something else than NO_MOVE_MADE and
	 * NO_HINT it will also update the history.
	 *
	 * @param column a chosen column to flush
	 * @param helpTextId a chosen helptextID (from HINTS) or
	 *
	 * DO NOT CHANGE THIS METHOD!
	 */
	private void printMap( int column, int helpTextId ) {
		// Update history
		// This would not write anything even if we did an update
		if( column != NO_MOVE_MADE ) {
			history[movesMade()] = column;
		}
		if( helpTextId != NO_HINT ) {
			historyHelpers[movesMade() - 1] = helpTextId;
		}

		boolean hasWon = column == mineShaftId;
		int currentMove = movesMade();

		System.out.println();
		if( movesMade() > 0 )
			System.out.println( "You flush mine shaft " + getMineShaftAsChar(column)  );
		if( column == mineShaftId ){ // Did we get the orcs?
			System.out.println();
			System.out.println( "You have stopped the orc chieftain!"  );
			System.out.println();
		} else {
				System.out.println();
				System.out.println();
		}
		// Build and print the header.
		String header = "|";
		for(int col = 0; col < MINE_SHAFTS; col++){
			header += String.valueOf( getMineShaftAsChar( col ) ) + "|";
		}
		System.out.println( header + "\n" + getLine() );

		// Build the map
		int row = MAX_ATTEMPTS;
		while( row > 0 ){
			printRow( column, MAX_ATTEMPTS - row, currentMove);
			row -= 1;
		}
		System.out.println( getLine() );


		if ( !hasWon && movesMade() > 0 && movesMade() < MAX_ATTEMPTS){
			System.out.println(
					"Your Seismometer tells you that the orcs are "
							+ HINTS[ helpTextId ] );
		} else if ( movesMade() == MAX_ATTEMPTS ){
			System.out.println( ORCS ); // They got you.
		}

		// Print history:
		System.out.println( getLine() );
		if( movesMade() > 1 ) {
			System.out.println("History: ");
		}
		for( int historyEntry = 0; historyEntry < MAX_ATTEMPTS; historyEntry++ ) {
			int hintId = historyHelpers[ historyEntry ];
			if( hintId < HINTS.length && hintId >= 0 ) {
				System.out.println( ( historyEntry + 1 ) + ".: " + HINTS[ hintId ] );
			}
		}
	}

	/**
	 * A line we can use to structure the map.
	 *
	 * @ return a String made of "-"
	 */
	private String getLine() {
		// Add a line of (more or less) correct length.
		char[] line = new char[ 2*MINE_SHAFTS + 1 ];
		Arrays.fill( line, '-' );
		return new String( line );
	}

	/**
	 * Prints a row of the map.
	 *
	 * DO NOT CHANGE THIS METHOD UNLESS the special characters don't work on your stystem!
	 * (Document it if that's the case)
	 *
	 * @param column The column which the player chose.
	 * @param row The row we want to print.
	 * @param currentGuess The number of the current guess.
	 */
	private void printRow( int column, int row, int currentGuess) {
		if( row == currentGuess ){
			printOrcRow( row );
		}
		else {
			String output = "|";
			for (int col = 0; col < MINE_SHAFTS; col++) {
				// Did the player check this mine shaft?
				boolean checked = false;
				for (int i : history) {
					if (col == i) { //
						checked = true;
					}
				}
				// Is there stone ?
				boolean isThereStone = false;
				if ((col + row) % 2 == 0) {
					isThereStone = true;
				}
				String emptyField = isThereStone ? "#" : " "; // How we draw empty terrain
				String hitTerrain = isThereStone ? "▓" : "░"; // How we draw terrain we have flushed.

				if (row < currentGuess) { // Are we behind the orcs?
					output += (checked ? hitTerrain : "▒");
				} else {
					// Have we hit the chieftain? Celebrate with special character!
					if (column == mineShaftId && col == column && currentGuess == movesMade()) {
						hitTerrain = "■";
					}
					output += (checked ? hitTerrain : emptyField);
				}
				output += "|";
			}
			System.out.println( output );
		}
	}

	/**
	 * Print the row where the orcs are right now.
	 *
	 * DO NOT CHANGE THIS METHOD UNLESS the special characters don't work on your stystem!
	 *
	 * If DEBUG is set to true, print the exact location instead.
	 * @param row The row where the orcs are supposed to be right now.
	 */
	private void printOrcRow(int row) {
		if (!DEBUG) {
			System.out.println(ORCS);
		} else {
			String output = "|";
			for (int col = 0; col < MINE_SHAFTS; col++) {
				// Did the player check this mine shaft?
				boolean checked = false;
				for (int i : history) {
					if (col == i) { //
						checked = true;
					}
				}
				// Is there stone ?
				boolean isThereStone = false;
				if ((col + row) % 2 == 0) {
					isThereStone = true;
				}
				String emptyField = isThereStone ? "#" : " "; // How we draw empty terrain
				String hitTerrain = isThereStone ? "▓" : "░";

				// Is the chieftain there? Special character
				if (col == mineShaftId) {
					hitTerrain = "■";
				}
				output += hitTerrain;
				output += "|";
			}
			System.out.println(output);
		}
	}

	/**
	 * Determines column's number from its code.
	 * Here 'a' is 1st column and 'l' is 12th
	 * returns 0 on unrecognised codes.
	 *
	 * DO NOT CHANGE THIS METHOD!
	 */
	private int getColumnAsInt( char column ) {
		switch ( column ) {
			case 'a':
				return 0;
			case 'b':
				return 1;
			case 'c':
				return 2;
			case 'd':
				return 3;
			case 'e':
				return 4;
			case 'f':
				return 5;
			case 'g':
				return 6;
			case 'h':
				return 7;
			case 'i':
				return 8;
			case 'j':
				return 9;
			case 'k':
				return 10;
			case 'l':
				return 11;
			default:
				return PARSING_FAILED;
		}
	}

	/**
	 * Determines column's code from its integer
	 * Here 'a' is int 0 and 'l' is 11
	 * returns 'z' on unrecognised integers.
	 *
	 * DO NOT CHANGE THIS METHOD
	 */
	private char getMineShaftAsChar( int mineShaft ) {
		switch ( mineShaft ) {
			case 0:
				return 'a';
			case 1:
				return 'b';
			case 2:
				return 'c';
			case 3:
				return 'd';
			case 4:
				return 'e';
			case 5:
				return 'f';
			case 6:
				return 'g';
			case 7:
				return 'h';
			case 8:
				return 'i';
			case 9:
				return 'j';
			case 10:
				return 'k';
			case 11:
				return 'l';
			default:
				return 'z';
		}
	}

	/**
	 * Use this to print the intro screen.
	 *
	 * DO NOT CHANGE THIS METHOD UNLESS the special characters don't work on your stystem!
	 * (Document it if that's the case)
	 *
	 * @return a String made of orc
	 */
	private String generateOrcIntroScreen() {
		String orc = "                           __,='`````'=/__\n" +
				"                          '//  /-\\ /-\\ \\ `'         _,-,\n" +
				"                          //|     ,_)   (`\\      ,-'`_,-\\\n" +
				"                        ,-~~~\\   /||\\  /-,      \\==```` \\__\n" +
				"                       /        `----'     `\\     \\       \\/\n" +
				"                    ,-`                  ,   \\  ,.-\\       \\\n" +
				"                   /      ,               \\,-`\\`_,-`\\_,..--'\\\n" +
				"                  ,`    ,/,              ,>,   )     \\--`````\\\n" +
				"                  (      `\\`---'`  `-,-'`_,<   \\      \\_,.--'`\n" +
				"                   `.      `--. _,-'`_,-`  |    \\\n" +
				"                    [`-.___   <`_,-'`------(    /\n" +
				"                    (`` _,-\\   \\ --`````````|--`\n" +
				"                     >-`_,-`\\,-` ,          |\n" +
				"                   <`_,'     ,  /\\          /\n" +
				"                    `  \\/\\,-/ `/  \\/`\\_/V\\_/\n" +
				"                       (  ._. )    ( .__. )    **************\n" +
				"                       |      |    |      |    Stop The Orcs!\n" +
				"                        \\,---_|    |_---./    **************\n" +
				"                        ooOO(_)    (_)OOoo" +
				"\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
		return orc;
	}
}
