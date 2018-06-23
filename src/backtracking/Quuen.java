package backtracking;

//https://www.youtube.com/watch?v=5v6zdfkImms&t=2s
public class Quuen {
	static class Board {
		static final int QUEEN_COUNT = 8;
		static final int BOARD_SIZE = 8;
		int m_queen_count = 0;
		int m_solution_count = 0;
		char[][] m_board = new char[BOARD_SIZE][BOARD_SIZE];

		public Board() {
			for (int i = 0; i < m_board.length; i++) {
				for (int j = 0; j < m_board[i].length; j++) {
					m_board[i][j] = '-';
				}
			}
			m_queen_count = 0;
		}

		public void place(int row, int col) {
			if (m_board[row][col] != 'Q') {
				m_board[row][col] = 'Q';
				m_queen_count++;
			}
		}

		public void remove(int row, int col) {
			if (m_board[row][col] != '-') {
				m_board[row][col] = '-';
				m_queen_count--;
			}
		}
		
		public boolean isFull() {
			return m_queen_count == QUEEN_COUNT;
		}
		
		public boolean isSafe(int row, int col) {
			for (int i = 0; i < m_board.length; i++) {
				for (int j = 0; j < m_board[i].length; j++) {
					if ((i == row || j == col)) {
						if (m_board[i][j] != '-') {
							return false;
						}
					}
					if (row == col) {
						if (i == j) {
							if (m_board[i][j] != '-') {
								return false;
							}
						}
					}
					if (row + col == BOARD_SIZE - 1) {
						if (i + j == BOARD_SIZE - 1) {
							if (m_board[i][j] != '-') {
								return false;
							}
						}
					}
				}
			}

			return true;
		}

		public void draw() {
			for (int i = 0; i < m_board.length; i++) {
				for (int j = 0; j < m_board[i].length; j++) {
					System.out.print(m_board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Board board = new Board();
//		boolean found = eightQueen(board);
		eightQueenPrintAllResults(board, 0);
		System.out.println("Found " + board.m_solution_count);
		
		// board.place(0, 0);
		// assert board.isSafe(0, 1) == false;
		// assert board.isSafe(1, 0) == false;
		// assert board.isSafe(1, 1) == false;
		// assert board.isSafe(2, 3) == true;
//		board.draw();

	}

	private static void eightQueenPrintAllResults(Board board, int col) throws InterruptedException {
//		System.out.println("eightQueenPrintAllResults queen_count=" + board.m_queen_count + " col=" + col);
		if (col == 8) {
			// found solution
			if (board.isFull()) {
				board.draw();
				board.m_solution_count++;
				System.out.println("**************** " + board.m_solution_count);
				Thread.sleep(1000);
			}
		} else {
			// for each row in column
			for (int i = 0; i < Board.QUEEN_COUNT; i++) {
				// choose: try putting into one row in eight rows of that column
				// choose is updating the search space
				if (board.isSafe(i, col)) {
					board.place(i, col);
					// explore with that choice, in the rest of search space
					eightQueenPrintAllResults(board, col + 1);
					// unchoose
					board.remove(i, col);
				}
			}
		}
	}

	private static boolean eightQueen(Board board) {
		return eightQueenHelper(board, 0);
	}

	private static boolean eightQueenHelper(Board board, int col) {
		System.out.println("eightQueenHelper " + col);
		// base case
		if (col >= 8) {
			// found solution
			return true;
		} else {
			// for each row in column
			for (int i = 0; i < board.m_board.length; i++) {
				// choose: try putting into one row in eight rows of that column
				// choose is updating the search space
				if (board.isSafe(i, col)) {
					board.place(i, col);
					// explore with that choice, in the rest of search space
					boolean result = eightQueenHelper(board, col + 1);
					if (result) {
						return result;
					}
					// unchoose
					board.remove(i, col);
				}
			}
		}
		return false;
	}

}
