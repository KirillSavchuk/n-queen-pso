package lv.rtu.ks.pso;

import lv.rtu.ks.view.Board;
import lv.rtu.ks.view.Queen;
import lv.rtu.ks.view.QueenPositions;
import org.springframework.stereotype.Service;

import static lv.rtu.ks.pso.BoardParticleDiagonalConflictCalculator.Direction.*;

@Service
public class BoardParticleDiagonalConflictCalculator {

	private final int DIRECTION_COUNT = 4;
	private final int[] verticalDirection = new int[]{TOP, TOP, BOTTOM, BOTTOM};
	private final int[] horizontalDirection = new int[]{LEFT, RIGHT, RIGHT, LEFT};

	public int calculateQueensConflicts(QueenPositions queenPositions) {
		final Board board = new Board(queenPositions);
		return queenPositions.stream()
			.mapToInt(queen -> this.calculateOneQueenConflicts(board, queen))
			.sum();
	}

	protected int calculateOneQueenConflicts(Board board, Queen queen) {
		int queenConflict = 0;
		int queenRow = queen.getRow();
		int queenColumn = queen.getColumn();
		for (int direction = 0; direction < DIRECTION_COUNT; direction++) {
			int possibleQueenRow = queenRow;
			int possibleQueenColumn = queenColumn;
			while (true) {
				possibleQueenRow += horizontalDirection[direction];
				possibleQueenColumn += verticalDirection[direction];
				if (insideBoard(board.getBoardSize(), possibleQueenColumn, possibleQueenRow)) {
					if (board.isQueen(possibleQueenRow, possibleQueenColumn)) {
						queenConflict++;
					}
				} else {
					break;
				}
			}
		}
		return queenConflict;
	}

	protected boolean insideBoard(int boardSize, int row, int col) {
		return (row >= 0 && row < boardSize) && (col >= 0 && col < boardSize);
	}

	static class Direction {
		public static final int LEFT = -1;
		public static final int RIGHT = 1;
		public static final int TOP = -1;
		public static final int BOTTOM = 1;
	}

}
