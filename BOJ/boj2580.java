import java.util.Scanner;

public class boj2580 {
	public static int[][] sudoku = new int[9][9];
	
	public static void main(String[]args) {
		// 입력
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			for (int j = 0; j < 9 ; j++) {
				sudoku[i][j] = in.nextInt();
			}
		}
		
		fillSudoku(0, 0);
	}
	public static boolean isPossible(int row, int col, int value) {
		//행 검사
		for(int i = 0; i < 9; i++) {
			if(sudoku[row][i] == value) {
				return false;
			}
		}
		//열 검사
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][col] == value) {
				return false;
			}
		}
		//3x3 검사
		int rowSquare = (row/3) * 3;
		int colSquare = (col/3) * 3;
		
		for(int i = rowSquare; i < rowSquare + 3; i++) {
			for(int j = colSquare; j < colSquare + 3; j++) {
				if(sudoku[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void fillSudoku(int row, int col) {
		if(row == 9) {
			for(int i = 0; i < 9; i++) {
				for (int j = 0; j < 9 ; j++) {
					System.out.print(sudoku[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(col == 9) {
			fillSudoku(row+1, 0);
			return;
		}
		
		if(sudoku[row][col] == 0) {
			for(int i = 1; i < 10; i++) {
				if(isPossible(row, col, i)) {
					sudoku[row][col] = i;
					fillSudoku(row, col+1);
				}
			}
			sudoku[row][col] = 0;
			return;
		}
		fillSudoku(row, col+1);
	}
} 
