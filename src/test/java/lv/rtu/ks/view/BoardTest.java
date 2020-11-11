package lv.rtu.ks.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {

	private Board board;

	@BeforeEach
	public void setUp() {
		board = new Board(new int[]{1, 2, 0, 0, 4});
	}

	@ParameterizedTest
	@MethodSource("queenLocations")
	void isQueen_shouldBeQueen(int row, int col) {
		assertTrue(board.isQueen(row, col));
	}

	@ParameterizedTest
	@MethodSource("notQueenLocations")
	void isQueen_shouldBeEmpty(int row, int col) {
		assertFalse(board.isQueen(row, col));
	}

	private static Stream<Arguments> queenLocations() {
		return Stream.of(
			Arguments.of(0, 1),
			Arguments.of(1, 2),
			Arguments.of(2, 0),
			Arguments.of(3, 0),
			Arguments.of(4, 4)
		);
	}

	private static Stream<Arguments> notQueenLocations() {
		return Stream.of(
			Arguments.of(0, 0),
			Arguments.of(1, 1),
			Arguments.of(2, 2),
			Arguments.of(3, 3),
			Arguments.of(4, 0)
		);
	}

}