import java.util.Scanner;

public class Main {

// player one and two pieces (Tanish)

public static void main(String[] args) {
	String player1, player2;
	char currentPlayer;
// create a new instance of the Gomoku game (Ryan)

GoMoKu game = new GoMoKu();

//creates a scanner object (Tanish)

Scanner scanner = new Scanner(System.in);
//Asks the user if they want to play with a computer/AI or Human player (Tanish)
System.out.println("Do you want to play with the computer(C) or a human player(H)");
String compplayer=scanner.next();
if(compplayer.equals("C"))
{
	//Asks the user if they selected Computer(C) it will give 3 options to select from (Tanish)
	System.out.println("Random Placement(R), Ordered Placement(O) or Strategic Placement(S)?");
	//Random placement has the computer randomly place it, ordered has the computer place it in straight lines, and Strategic has it place it so it almost blocks the player's next move (Tanish)
	String placement = scanner.next();
	currentPlayer='X';
	if(placement.equals("R")) //this if else statement is for random placement (Tanish)
	{
		while(true) //This is a while loop that prints out the board (Tanish)
		{
			System.out.println("Current board:"); //Prints out the board (Tanish)

			game.print();
			if(currentPlayer=='0')
			{
				game.randomPlacement(); //This gives the Computer/AI command to place it randomly on the board
				currentPlayer='X'; //This gives the Non-AI player their chance
			}
			else
			{
				System.out.println(currentPlayer

				+ ", enter the (X,Y) coordinates to place your stone and make sure it's seperated by a space (EX: 1 1). Now good luck you do it:");

				//accept the x coordinate (Ryan)

				int x = scanner.nextInt() - 1;

				//accept the y coordinate (Tanish)

				int y = scanner.nextInt() - 1;

				// Place the stone and check for a win (Ryan and Tanish)

				if (game.placeStone(y, x, currentPlayer)) { //nested if statement checking win

					if (game.winner(currentPlayer)) {

						System.out.println(currentPlayer + " wins!");

						//checks who won (Tanish)

						break;

					} 
					else 
					{

						//switches the player (Ryan and Tanish)
						currentPlayer='0';
					}


				} 
				else 
				{

					//prints the message if the player entered a pre-occupied spot! (Ryan and Tanish)

					System.out.println("This place has already been occupied. Please select a different spot!");

				}

		}
}
	}
	else if(placement.equals("O")) //This is and else if statement that gives ordered placement for AI/Computer (Tanish)
	{
		while(true)
		{
			System.out.println("Current board:"); //This prints out the current board (Tanish)

			game.print();
			if(currentPlayer=='0') //This declares it so computer can start playing (Tanish)
			{
				game.orderedPlacement(); //This gives the computer a command to do ordered placement (Tanish)
				currentPlayer='X';
			}
			else
			{
				System.out.println(currentPlayer

				+ ", enter the (X,Y) coordinates to place your stone and make sure it's seperated by a space (EX: 1 1). Now good luck you do it:");

				//accept the x coordinate (Ryan)

				int x = scanner.nextInt() - 1;

				//accept the y coordinate (Tanish)

				int y = scanner.nextInt() - 1;

				// Place the stone and check for a win (Ryan and Tanish)

				if (game.placeStone(y, x, currentPlayer)) {

					if (game.winner(currentPlayer)) {

						System.out.println(currentPlayer + " wins!");

						//checks who won (Tanish)

						break;

					} 
					else 
					{

						//switches the player (Ryan and Tanish)
						currentPlayer='0';
					}


				} 
				else 
				{

					//prints the message if the player entered a pre-occupied spot! (Ryan and Tanish)

					System.out.println("This place has already been occupied. Please select a different spot!");

				}

		}
}
	}
	else if(placement.equals("S")) //This is the else if for Strategic placement for AI (Tanish)
	{
		while(true)
		{
			System.out.println("Current board:"); //Prints out the board (Tanish)

			game.print();
			if(currentPlayer=='0')
			{
				game.strategicPlacement(); //Gives the computer commands to play strategically (Tanish)
				currentPlayer='X';
			}
			else
			{
				System.out.println(currentPlayer

				+ ", enter the (X,Y) coordinates to place your stone and make sure it's seperated by a space (EX: 1 1). Now good luck you do it:");

				//accept the x coordinate (Ryan)

				int x = scanner.nextInt() - 1;

				//accept the y coordinate (Tanish)

				int y = scanner.nextInt() - 1;

				// Place the stone and check for a win (Ryan and Tanish)

				if (game.placeStone(y, x, currentPlayer)) {

					if (game.winner(currentPlayer)) {

						System.out.println(currentPlayer + " wins!");

						//checks who won (Tanish)

						break;

					} 
					else 
					{

						//switches the player (Ryan and Tanish)
						currentPlayer='0';
					}


				} 
				else 
				{

					//prints the message if the player entered a pre-occupied spot! (Ryan and Tanish)

					System.out.println("This place has already been occupied. Please select a different spot!");

				}

		}
}
	}
}	
else
{
//asks the user to enter the name of the player1 (Tanish)

System.out.println("Enter the name of Player1: ");

//accept the name of player1 (Tanish)

 player1 = scanner.next();

//asks the user to enter the name of the player2 (Tanish)

System.out.println("Enter the name of Player2: ");

//accept the name of player2 (Tanish)

player2 = scanner.next();

//Starts with player1 (Tanish)
 currentPlayer = 'X';

String player = player1;

//the main game loop (Ryan)

while (true) {

//prints the current board (Ryan)

System.out.println("Current board:");

game.print();

// Prompt the player to place their stone (Tanish and Ryan)

System.out.println("Loading...");

System.out.println(player

+ ", enter the (X,Y) coordinates to place your stone and make sure it's seperated by a space (EX: 1 1). Now good luck you do it:");

//accept the x coordinate (Ryan)

int x = scanner.nextInt() - 1;

//accept the y coordinate (Tanish)

int y = scanner.nextInt() - 1;

// Place the stone and check for a win (Ryan and Tanish)

if (game.placeStone(y, x, currentPlayer)) {

if (game.winner(currentPlayer)) {

System.out.println(player + " wins!");

//checks who won (Tanish)

break;

} else {

//switches the player (Ryan and Tanish)

if(currentPlayer == 'X') {

player = player2;

currentPlayer = '0';

}

else {

player = player1;

currentPlayer = 'X';

}

}

} else {

//prints the message if the player entered a pre-occupied spot! (Ryan and Tanish)

System.out.println("This place has already been occupied. Please select a different spot!");

}

}

//closes the scanner object (Ryan)

scanner.close();
}
}}
