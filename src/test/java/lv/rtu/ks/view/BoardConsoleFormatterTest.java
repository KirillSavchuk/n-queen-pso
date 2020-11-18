package lv.rtu.ks.view;

import org.junit.jupiter.api.Test;

import static lv.rtu.ks.utils.ArrayUtil.toArray;
import static lv.rtu.ks.view.BoardConsoleFormatter.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BoardConsoleFormatterTest {

	@Test
	void format_shouldReturnFormattedBoard() {
		Board board = new Board(new QueenPositions(toArray(1, 2, 0, 0, 4)));
		String expectedConsoleFormattedBoard =
			"---------------------\n" +
			"| - | # | - | - | - |\n" +
			"---------------------\n" +
			"| - | - | # | - | - |\n" +
			"---------------------\n" +
			"| # | - | - | - | - |\n" +
			"---------------------\n" +
			"| # | - | - | - | - |\n" +
			"---------------------\n" +
			"| - | - | - | - | # |\n" +
			"---------------------";
		assertThat(format(board)).isEqualTo(expectedConsoleFormattedBoard);
	}

	@Test
	void calculateHorizontalLineSeparator_shouldReturnEmptyString_ifZero() {
		assertThat(calculateHorizontalLineSeparator(0)).isEqualTo("");
	}

	@Test
	void calculateHorizontalLineSeparator_shouldReturnRepeatingCharacters() {
		String horizontalLineSeparator = calculateHorizontalLineSeparator(5);
		assertThat(horizontalLineSeparator.length()).isEqualTo(21);
	}

	@Test
	void queenOrEmpty_shouldReturnQueenSymbol_ifQueen() {
		assertThat(queenOrEmpty(true)).isEqualTo(SYMBOL_QUEEN);
	}

	@Test
	void queenOrEmpty_shouldReturnEmptySymbol_ifNoQueen() {
		assertThat(queenOrEmpty(false)).isEqualTo(SYMBOL_EMPTY);
	}

}