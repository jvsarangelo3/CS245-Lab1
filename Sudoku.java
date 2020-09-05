// Jacelle Sarangelo, Connor Barski
// Section 02

import java.util.Scanner;

public class Sudoku {
	private static final int SIZE = 9; // size of rows

	//A function to print the board
	private static void printBoard(int[][] board) {
		//nested for loop to iterate through and print the board
		for (int i = 0; i < SIZE; i++) {
			if ((i) % 3 == 0) {
				System.out.print("_______________________");
				System.out.println();
			}
			System.out.println();
			for (int j = 0; j < SIZE; j++) {
				System.out.print(board[i][j] + " ");

				if ((j + 1) % 3 == 0) {
					System.out.print("| ");
				}
			}
			System.out.println();
		}
	}

	//Checker function to check row, column and 3x3 box
	public static boolean checker(int[][] board, int num, int row, int col) {
		// checks row
		for (int i = 0; i < SIZE; i++) {
			if (board[row][i] == num) {
				return false;
			}
		}

		// checks col
		for (int i = 0; i < SIZE; i++) {
			if (board[i][col] == num) {
				return false;
			}
		}
		
		//Find the start point for row and column
		int rStart = (row / 3) * 3;
		int cStart = (col / 3) * 3;

		//Check in a 3x3 box
		for (int i = rStart; i < rStart + 3; i++) {
			for (int j = cStart; j < cStart + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}
		//If no issues, return true
		return true;
	}

	//Function to solve sudoku
	public static boolean solveBoard(int[][] board) {

		//Initialize row and column to 0, so when called recursively starts at the beginning of the 2D array
		int row = 0, col = 0;
		boolean flag = true;

		//Nested for loop to check for an empty spot on the sudoku board, also is a base case
		for(row = 0; row<SIZE; row++)
		{
			for(col = 0; col<SIZE; col++)
			{
				if(board[row][col] == 0)
				{
					flag = false;
					break;
				}
			}
			if(flag == false)
			{
				break;
			}
		}

		//If there are no empty spots on the board, returns true and the base case is fulfilled
		if(flag == true)
		{
			return true;
		}

		//If the base case is not fulfilled, try numbers 1-9 in the empty spot 
		for (int n = 1; n <= SIZE; n++) {
			if (checker(board, n, row, col)) {
				//If the number works in that spot, place the number at the position
				board[row][col] = n;

				//Recursively call solveBoard
				if(solveBoard(board) == true)
				{
					return true;
				}
				//If no number can be placed in the position, change it back to 0 and backtrack
				else 
				{
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	//Main
	public static void main(String[] args) {
		//Initialize an empty board
		int[][] board = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		String[] tempString;
		Sudoku sudoku = new Sudoku();
		Scanner input = new Scanner(System.in);

		//Have the user enter 9 digits 9 times for each row
		for (int i = 0; i < SIZE; i++) {
			System.out.println("Enter 9 digits from 0 - 9 in the row\n(with 0 meaning it's an empty space)\n and separate the values with a space");
			String s = input.nextLine();

			//split the user's numbers with a space
			tempString = s.split(" ");

			for (int j = 0; j < SIZE; j++) {
				if(!Character.isDigit(tempString[j].charAt(0))) {
					tempString[j] = "0";
				}

				int num = Integer.parseInt(tempString[j]);

				if (num > SIZE || num < 0) {
					num = 0;
				}

				board[i][j] = num;
			}
		}

		//Diaplay the empty board
		System.out.println("Board:");
		printBoard(board);
		System.out.println();

		//If solveBoard returns true, print the solution
		if (solveBoard(board)) {
			System.out.println("Solution:\n");
			printBoard(board);
		}
		//If solveBoard returns false, say no solution
		else {
			System.out.println("No Solution.");
		}
	}
}