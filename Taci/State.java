package Taci;

public class State {
    private int[][] board;
    
    public State() {
        this.board = new int[][] { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
    }
    
    public State(int[][] board) {
        this.board = board;
    }
    
    public State(Vertex board) {
        this.board = board.getState().getBoard();
    }
    

    public State moveUp(int zeroRow ,int zeroCol) {
    	if(zeroRow - 1 >= 0) {
	        int[][] newBoard = new int[3][3];
	        copyBoard(board, newBoard);
	        newBoard[zeroRow][zeroCol] = newBoard[zeroRow - 1][zeroCol];
	        newBoard[zeroRow - 1][zeroCol] = 0;
	        return new State(newBoard);
    	}
    	return this;
    }

    public State moveDown(int zeroRow,int zeroCol) {
    	if(zeroRow + 1 < 3) {
	        int[][] newBoard = new int[3][3];
	        copyBoard(board, newBoard);
	        newBoard[zeroRow][zeroCol] = newBoard[zeroRow + 1][zeroCol];
	        newBoard[zeroRow + 1][zeroCol] = 0;
	        return new State(newBoard);
    	}
    	return this;
    }

   
    public State moveLeft(int zeroRow,int zeroCol) {
    	if(zeroCol - 1 >= 0) {
	        int[][] newBoard = new int[3][3];
	        copyBoard(board, newBoard);
	        newBoard[zeroRow][zeroCol] = newBoard[zeroRow][zeroCol - 1];
	        newBoard[zeroRow][zeroCol - 1] = 0;
	        return new State(newBoard);
    	}
    	return this;
    }

    public State moveRight(int zeroRow,int zeroCol) {
    	if(zeroCol + 1 < 3) {
	        int[][] newBoard = new int[3][3];
	        copyBoard(board, newBoard);
	        newBoard[zeroRow][zeroCol] = newBoard[zeroRow][zeroCol + 1];
	        newBoard[zeroRow][zeroCol + 1] = 0;
	        return new State(newBoard);
    	}
    	return this;
    }
    
	 private void copyBoard(int[][] src, int[][] dest) {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                dest[i][j] = src[i][j];
	            }
	        }
	    }

    public int[][] getBoard() {
        return board;
    }
    
	public void setBoard(int[][] board) {
			this.board = board;
		}
	
	
    public String toString() {
    	String s = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				s += (board[i][j] + " ");
//			s += "\n";
//			s += "      ";
		}
		return s;
	}
    
}