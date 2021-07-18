import java.util.Scanner;

public class TicTacToe {
	  
	public static void main(String[] args) {
		
		char[][] board = new char[3][3];
		int filledSpots = board.length * board[0].length;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}

		Scanner in = new Scanner(System.in);
		String p1 = "Player1";
		String p2 = "Player2";

		boolean player1 = true;

		boolean gameEnded = false;
		while(!gameEnded) {
			drawBoard(board);

			if(player1) {
				System.out.println(p1 + "'s Turn (x)");
			} else {
				System.out.println(p2 + "'s Turn (o)");
			}

			char c = '-';
			c = player1 ? 'x' : 'o';

			int row = 0;
			int col = 0;

			while(true) {
				System.out.print("Row ? (1-3): ");
				row = in.nextInt()-1;
				System.out.print("Collum ? (1-3): ");
				col = in.nextInt()-1;
				if(row < 0 || col < 0 || row > 2 || col > 2) {
					System.out.println("Out of Bounds");
				} else if(board[row][col] != '-') {
					System.out.println("Position taken!");
				} else {
					break;
				}
			
			}

			board[row][col] = c;
			filledSpots++;

			if(checkWin(board) == 'x') {
				System.out.println(p1 + " has won!");
				gameEnded = true;
			} else if(checkWin(board) == 'o') {
				System.out.println(p2 + " has won!");
				gameEnded = true;
			} else {

				if(filledSpots == 18) {
					System.out.println("It's a tie!");
					gameEnded = true;
				} else {
					player1 = !player1;
				}

			}

		}
		drawBoard(board);
		in.close();
  }

	public static void drawBoard(char[][] board) {
		System.out.println("Board:");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static char checkWin(char[][] board) {
		for(int i = 0; i < 3; i++) {
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
				return board[i][0];
			}
		}
		for(int j = 0; j < 3; j++) {
			if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
				return board[0][j];
			}
		}
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
			return board[0][0];
		}
		if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
			return board[2][0];
		}
		return ' ';

	}
}