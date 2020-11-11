package lv.rtu.ks.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Board {

	private int boardSize;
	private boolean[][] board;

	public Board(int[] horizontalPositions) {
		this.boardSize = horizontalPositions.length;
		this.board = new boolean[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			board[horizontalPositions[i]][i] = true;
		}
	}

	public boolean isQueen(int row, int col) {
		return board[row][col];
	}

}
