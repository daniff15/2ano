package lab03;

public class JGaloGameMaster implements JGaloInterface {

    private char[][] grid = new char[3][3];
    private char actualPlayer;
    private boolean finished = false;
    private char result = ' ';
    private int movesPlayed = 0;

    public JGaloGameMaster(char startingPlayer) {
        
        actualPlayer = startingPlayer;

    }

    public char getActualPlayer() {
        return actualPlayer;
    }

	public boolean setJogada(int lin, int col) {
		// fixing indexes >:| 
		lin--;
		col--;
        grid[lin][col] = actualPlayer;
        movesPlayed++;
        
        // check the line and column
        // If the sum of the ascii codes is equal to the actualPlayer's ascii code times 3, then a line of 3 was made
        if ( grid[lin][0] + grid[lin][1] + grid[lin][2] == actualPlayer*3 ||
             grid[0][col] + grid[1][col] + grid[2][col] == actualPlayer*3) {
                
                finished = true;
                result = actualPlayer;
                return true;
        }
        // check if it's a corner or the center
        if ( lin == col || lin + 2 == col || col + 2 == lin ) {
            // in which case, check diagonals, doing both is fine
            finished = grid[0][0] + grid[1][1] + grid[2][2] == actualPlayer*3 ||
                        grid[2][0] + grid[1][1] + grid[0][2] == actualPlayer*3;
            
            if (finished) {
                result = actualPlayer;
                return true;
            }
        }

        // next player
        actualPlayer = actualPlayer == 'X' ? 'O' : 'X';
        return false;
    }

	public boolean isFinished() {
        return finished || movesPlayed == 9;
    }

	public char checkResult() {
        return result;
    }
}
