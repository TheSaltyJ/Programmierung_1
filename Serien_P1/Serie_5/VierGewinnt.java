/* ************************* *\
*                Programmierung 1 HS 2018 - Serie 5-1                         *
*        Jonas Gehrlein (15-127-541) & Jan Dietrich (10-100-436)          *
\* ************************* */

import java.util.Arrays;
import java.util.Scanner;


public class VierGewinnt
{

	public static final int COLS = 7;
	public static final int ROWS = 6;

	private Token[][] board = new Token[ COLS ][ ROWS ]; // 7 columns with 6 fields each
	private IPlayer[] players = new IPlayer[ 2 ]; // two players

	/** initialize board and players and start the game */
	public void play()
	{
		// initialize the board
		for ( Token[] column : this.board ) {
			Arrays.fill( column, Token.empty );
		}

		/* initialize players */
		players[ 0 ] = new HumanPlayer();
		System.out.print( "Play against a human opponent? (y / n) " );
		String opponent = new Scanner( System.in ).nextLine().toLowerCase();
		while ( ( 1 != opponent.length() ) || ( -1 == ( "yn".indexOf ( opponent ) ) ) ) {
			System.out.print( "Can't understand your answer. Play against a human opponent? (y / n) " );
			opponent = new Scanner( System.in ).nextLine().toLowerCase();
		}
		if ( opponent.equals( "y" ) ) {
			players[ 1 ] = new HumanPlayer();
		} else {
			players[ 1 ] = new ComputerPlayer();
		}
		players[ 0 ].setToken( Token.player1 );
		players[ 1 ].setToken( Token.player2 );

		/* play... */
		boolean solved = false;
		int currentPlayer = ( new java.util.Random() ).nextInt( 2 );  //choose randomly who begins
		System.out.println( "current player: " + currentPlayer );
		int insertCol, insertRow; // starting from 0
		while ( !solved && !this.isBoardFull() ) {
			// get player's next "move"
			// note that we pass only a copy of the board as an argument,
			// otherwise the player would be able to manipulate the board and cheat!
			insertCol = players[ currentPlayer ].getNextColumn( getCopyOfBoard() );
			// insert the token and get the row where it landed
			insertRow = this.insertToken( insertCol, players[ currentPlayer ].getToken() );
			// check if the game is over
			solved = this.checkVierGewinnt( insertCol, insertRow );
			//switch to other player
			if ( !solved )
				currentPlayer = ( currentPlayer + 1 ) % 2;
		}
		System.out.println( displayBoard( this.board ) );
		if ( solved )
			System.out.println( "Player " + players[ currentPlayer ].getToken() + " wins!" );
		else
			System.out.println( "Draw! Game over." );
	}


	/**
	 * Inserts the token at the specified column (if possible)
	 * @param column the column to insert the token
	 * @param token the players token
	 * @return the row where the token landed 
	 */
	private int insertToken( int column, Token tok )
	{
            int row = 0;
            for ( Token token : this.board[column]) {
                if (token == Token.empty) {
                    this.board[column][row] = tok;
                    return row;
                }
                row++;
            }
            System.exit(1);
            return -1;
	}


	/**
	 * Checks if every position is occupied 
	 * @returns true, if the board is full.
	 */
	private boolean isBoardFull()
	{
            for ( Token[] column : this.board) {
                for ( Token token : column) {
                    if (token == Token.empty) {
                        return false;
                    }
                }

            }
            return true;
	}


	/**
	 * Checks for at least four equal tokens in a row in
	 * either direction, starting from the given position. 
	 */
	private boolean checkVierGewinnt( int col, int row )
	{
                return this.checkVierDown(col, row) || this.checkVierHorizontal(col, row) || this.checkVierDiaLeft(col, row) || this.checkVierDiaRight(col, row);
	}

	private boolean checkVierDown ( int col, int row ) {
            if (row < 3) {
                return false;
            }
            Token[] column = this.board[col];
            for ( int i = 1 ; i <= 3; i++) {
                if (this.board[col][row-i] != this.board[col][row]) {
                    return false;
                }
            }
            return true;
        }
	private boolean checkVierHorizontal ( int col, int row ) {
            int counter=0;
            for ( int i = 1 ; i <= 3; i++) {

            }
            return false;
        }

	private boolean checkVierDiaLeft ( int col, int row ) {
            if (row < 3 || col < 3) {
                return false;
            }
            for ( int i = 1 ; i <= 3; i++) {
                if (this.board[col-i][row-i] != this.board[col][row]) {
                    return false;
                }
            }
            return true;
        }
	private boolean checkVierDiaRight ( int col, int row ) {
            if (row < 3 || col > COLS - 1 - 3) {
                return false;
            }
            for ( int i = 1 ; i <= 3; i++) {
                if (this.board[col+i][row-i] != this.board[col][row]) {
                    return false;
                }
            }
            return true;
        }


	/** Returns a (deep) copy of the board array */
	private Token[][] getCopyOfBoard()
	{
		Token[][] copiedBoard = new Token[ COLS ][ ROWS ];
		for ( int i = 0; i < copiedBoard.length; i++ ) {
			for ( int j = 0; j < copiedBoard[ i ].length; j++ ) {
				copiedBoard[ i ][ j ] = this.board[ i ][ j ];
			}
		}
		return copiedBoard;
	}


	/** returns a graphical representation of the board */
	public static String displayBoard( Token[][] myBoard )
	{
		String rowDelimiter = "+";
		String rowNumbering = " ";
		for ( int col = 0; col < myBoard.length; col++ ) {
			rowDelimiter += "---+";
			rowNumbering += " " + ( col + 1 ) + "  ";
		}
		rowDelimiter += "\n";

		String rowStr;
		String presentation = rowDelimiter;
		for ( int row = myBoard[ 0 ].length - 1; row >= 0; row-- ) {
			rowStr = "| ";
			for ( int col = 0; col < myBoard.length; col++ ) {
				rowStr += myBoard[ col ][ row ].toString() + " | ";
			}
			presentation += rowStr + "\n" + rowDelimiter;
		}
		presentation += rowNumbering;
		return presentation;
	}



	/** main method, starts the program */
	public static void main( String args[] )
	{
		VierGewinnt game = new VierGewinnt();
		game.play();
	}
}
