public class GoMoKu {

	//setting the board size as 19 the original (Ryan & Tanish)

	private static final int SIZE = 19;

	//creating a 2D character array as board (Ryan)

	private char[][] board;

	//constructor - initializes the board with hyphens (Ryan)

	public GoMoKu () {

		//Create a 2-D character array
		board = new char[SIZE][SIZE];

		//Traverse the row 
		for (int row = 0; row < board.length; row++) {
			//Traverse the colums
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = '-'; // initialize each position with hyphen
			}
		}
	}

// Displays the entire board (Ryan)

public void print() {
	//Traverse the rows
	for (int row = 0; row < board.length; row++) {
		//Traverse the columns
		for (int col = 0; col < board[row].length; col++) {
			//prints the elements of the board separated by space
			System.out.print(board[row][col] + " ");
		}
		//prints the new line after each row
		System.out.println();
	}
}


	//Random placement of stones (Author : Tanish)
	public void randomPlacement()
	{
		boolean flag=false; //setting flag as false 
		do
		{
			flag=placeStone((int)(Math.random()*15),(int)(Math.random()*15),'0'); // generating random x, y values between 0 and 14.
		}while(flag==false); // checking whether placement of stone is successful. If not, generate a new random position.
	}
	//Ordered placement of stones (Author : Tanish)
	public void orderedPlacement()
	{
		for(int i=0;i<SIZE;i++)//Traverse each row
		{
			for(int j=0;j<SIZE;j++)//Traverse each column
			{
				if(isEmpty(i,j))//Checks whether the position is empty
				{
					placeStone(i,j,'O'); // Places the stone in the empty position
					return; // Once stone is placed, return
				}
			}
		}
	}
	//Strategic placement of stones (Author : Tanish)
	public void strategicPlacement()
	{
		boolean flag=false;
		//Checking if there are consecutive stones in rows
		for (int i = 0; i < SIZE; i++) { // Traverse each row
			int count = 0; // Initialize count to 0
			for (int j = 0; j < SIZE; j++) {//Traverse each column
				if (board[i][j] == 'X') { // Checks if the stone (X) is placed in a cell
					count++; // Keeps track of the number of consecutive stones in a row.
				} 
				else {
					count = 0; // If there are no consecutive stones, start the count from 0
				}
				if (count >= 2) { // Checks if there are more than 2 consecutive stones in a row
					flag=placeStone(i,j+1,'0'); // Place the stone in the next consecutive position
					if(flag==true)// Return if stone placement is successful
						return;
					else // Else restart the counter from 0
						count=0;
				}
			}
		}
		//Checs whether there are consecutive stones in a column
		for (int i = 0; i < SIZE; i++) {//Traverse the column
			int count = 0; //Initializing count to 0
			for (int j = 0; j < SIZE; j++) {//Traverse the row
				if (board[j][i] == 'X') {// Checks if the cell contains the stone (X)
					count++; //Keeps track of the number of consecutive stones in a column
				} 
				else {
					count = 0;//If there are no consecutive stones, reset the counter to 0
				}
				if (count >= 2) {//If there are more than 2 consecutive stones in a column
					flag=placeStone(j+1,i,'0'); // Place the stone at the next consecutive position
					if(flag==true)//If the placement is successful, return
						return;
					else 
						count=0;//else reset the counter
				}
			}
		}
		if(flag==true)
			return;
		else // If the stone placement is not successful, generate a random position to place the stones
		{
			do
			{
				int x=(int)(Math.random()*19); // random x value generated
				int y=(int)(Math.random()*19);//random y value generated
				flag = placeStone(x, y, '0');//Place the stone at the generated random position
			}while(flag==false); // create random position as long as the generated position is already filled
		}
	}
	public boolean isEmpty(int row,int col)
	{
		if(board[row][col]=='-')
			return true;
		else
			return false;
	}
	// place a stone based on row and column (Ryan did main part Tanish edited/cleaned it up)

	public boolean placeStone(int r, int c, char placeholder) {

//checks for the given row & column is empty (Ryan did main part Tanish edited/cleaned it up)

if (board[r][c] == '-') {

//if it's empty it places a stone and returns true (Ryan did main part Tanish edited/cleaned it up)

board[r][c] = placeholder;

return true;

}

//returns false if it's not empty (Ryan)

return false;

}

//this checks the different types of wins on the board (Ryan did main part Tanish edited/cleaned it up)

public boolean winner(char stone) {

//Checks for a horizontal win (Ryan did main part Tanish edited/cleaned it up)

for (int row = 0; row < board.length; row++) {

//stores the count as 0 (Tanish)

int count = 0;

//checks the column in that row (Ryan did main part Tanish edited/cleaned it up)

for (int col = 0; col < board[row].length; col++) {

//counts the number of stones (Ryan did main part Tanish edited/cleaned it up)

if (board[row][col] == stone) {

count++;

} else {

count = 0;

}

//if number of stones is 5 it shows a win (Ryan did main part Tanish edited/cleaned it up)

if (count == 5) {

return true;

}

}

}

//Checks for a vertical win (Ryan did main part Tanish edited/cleaned it up)

for (int row = 0; row < board.length; row++) {

int count = 0;

//goes to each row (Ryan did main part Tanish edited/cleaned it up)

for (int col = 0; col < board[row].length; col++) {

//goes to each column (Ryan did main part Tanish edited/cleaned it up)

//checks for the number of stones column wise (Ryan did main part Tanish edited/cleaned it up)

if (board[col][row] == stone) {

count++;

} else {

count = 0;

}

//if the stone count is equal to 5 it returns a win! (Ryan did main part Tanish edited/cleaned it up)

if (count == 5) {

return true;

}

}

}

//Checks for a diagonal win (Ryan did main part Tanish edited/cleaned it up)

for (int row = 0; row < board.length - 4; row++) {

//goes by each row (Ryan did main part Tanish edited/cleaned it up)

for (int col = 0; col < board[row].length - 4; col++) {

//goes by each column (Ryan did main part Tanish edited/cleaned it up)

int count = 0;

//check for the number of stones in the left diagonal (Ryan did main part Tanish edited/cleaned it up)

for (int d = 0; d < 5; d++) {

if (board[row + d][col + d] == stone) {

count++;

} else {

count = 0;

}

//if the stone count is equal to 5 it returns a win! (Ryan did main part Tanish edited/cleaned it up)

if (count == 5) {

return true;

}

}

}

}

// Check for diagonal win (Ryan did main part Tanish edited/cleaned it up)

for (int row = 0; row < board.length - 4; row++) {

//goes by each row (Ryan did main part Tanish edited/cleaned it up)

for (int col = board[row].length - 1; col >= 4; col--) {

//goes by each column (Ryan did main part Tanish edited/cleaned it up)

int count = 0;

//check for the number of stones in the right diagonal (Ryan did main part Tanish edited/cleaned it up)

for (int d = 0; d < 5; d++) {

if (board[row + d][col - d] == stone) {

count++;

} else {

count = 0;

}

//if the stone count is equal to 5 it returns a win! (Ryan did main part Tanish edited/cleaned it up)

if (count == 5) {

return true;

}

}

}

}

//if no win then it returns false (Ryan)

return false;

}

}