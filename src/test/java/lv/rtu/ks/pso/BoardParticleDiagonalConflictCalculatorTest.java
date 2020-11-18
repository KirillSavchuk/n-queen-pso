package lv.rtu.ks.pso;

import lv.rtu.ks.view.Board;
import lv.rtu.ks.view.Queen;
import lv.rtu.ks.view.QueenPositions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lv.rtu.ks.utils.ArrayUtil.toArray;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardParticleDiagonalConflictCalculatorTest {

	private final BoardParticleDiagonalConflictCalculator conflictCalculator = new BoardParticleDiagonalConflictCalculator();

	@ParameterizedTest
	@MethodSource("expectedQueensConflicts")
	void calculateQueensConflicts(QueenPositions queenPositions, int expectedConflictCount) {
		assertThat(conflictCalculator.calculateQueensConflicts(queenPositions)).isEqualTo(expectedConflictCount);
	}

	private static Stream<Arguments> expectedQueensConflicts() {
		return Stream.of(
			Arguments.of(new QueenPositions(toArray(0)), 0),
			Arguments.of(new QueenPositions(toArray(0, 1)), 2),
			Arguments.of(new QueenPositions(toArray(0, 0, 0, 0, 0)), 0),
			Arguments.of(new QueenPositions(toArray(0, 1, 2, 3, 4)), 20),
			Arguments.of(new QueenPositions(toArray(4, 3, 2, 1, 0)), 20),
			Arguments.of(new QueenPositions(toArray(3, 1, 0, 4, 2)), 4),
			Arguments.of(new QueenPositions(toArray(0, 3, 1, 4, 2)), 0)
		);
	}

	@ParameterizedTest
	@MethodSource("expectedOneQueenConflicts")
	void calculateQueenConflicts(Board board, Queen queen, int expectedConflictCount) {
		assertThat(conflictCalculator.calculateOneQueenConflicts(board, queen)).isEqualTo(expectedConflictCount);
	}

	private static Stream<Arguments> expectedOneQueenConflicts() {
		final Queen q1 = new Queen(0, 3);
		final Queen q2 = new Queen(1, 1);
		final Queen q3 = new Queen(2, 0);
		final Queen q4 = new Queen(3, 4);
		final Queen q5 = new Queen(4, 2);
		final Board board = new Board(new QueenPositions(q1, q2, q3, q4, q5));
		return Stream.of(
			Arguments.of(board, q1, 0),
			Arguments.of(board, q2, 1),
			Arguments.of(board, q3, 2),
			Arguments.of(board, q4, 0),
			Arguments.of(board, q5, 1)
		);
	}

	@ParameterizedTest
	@MethodSource("validInsideBoardPoints")
	void insideBoard_validPositionShouldReturnTrue(int boardSize, int row, int col) {
		assertTrue(conflictCalculator.insideBoard(boardSize, row, col));
	}

	private static Stream<Arguments> validInsideBoardPoints() {
		return Stream.of(
			Arguments.of(1, 0, 0),
			Arguments.of(5, 0, 0),
			Arguments.of(5, 0, 4),
			Arguments.of(5, 4, 0),
			Arguments.of(5, 4, 4),
			Arguments.of(5, 2, 2)
		);
	}

	@ParameterizedTest
	@MethodSource("invalidInsideBoardPoints")
	void insideBoard_invalidPositionShouldReturnFalse(int boardSize, int row, int col) {
		assertFalse(conflictCalculator.insideBoard(boardSize, row, col));
	}

	private static Stream<Arguments> invalidInsideBoardPoints() {
		return Stream.of(
			Arguments.of(5, 0, 5),
			Arguments.of(5, 5, 0),
			Arguments.of(5, 2, -1),
			Arguments.of(5, -1, 2),
			Arguments.of(0, 0, 0)
		);
	}

}