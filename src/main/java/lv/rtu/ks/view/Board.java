package lv.rtu.ks.view;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Board {

	@Getter
	private final int boardSize;
	private final boolean[][] board;

	public Board(QueenPositions queenPositions) {
		this.boardSize = queenPositions.size();
		this.board = new boolean[boardSize][boardSize];
		for (Queen queen : queenPositions) {
			board[queen.getRow()][queen.getColumn()] = true;
		}
	}

	public boolean isQueen(int row, int col) {
		return board[row][col];
	}

}
