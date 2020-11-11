package lv.rtu.ks.view;

import org.junit.jupiter.api.Test;

import static lv.rtu.ks.view.BoardConsoleFormatter.SYMBOL_EMPTY;
import static lv.rtu.ks.view.BoardConsoleFormatter.SYMBOL_QUEEN;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BoardConsoleFormatterTest {

	private final BoardConsoleFormatter formatter = new BoardConsoleFormatter();

	@Test
	void format() {
		Board board = new Board(new int[]{1, 2, 0, 0, 4});
		String expectedConsoleFormattedBoard =
			"---------------------\n" +
			"| - | - | # | # | - |\n" +
			"---------------------\n" +
			"| # | - | - | - | - |\n" +
			"---------------------\n" +
			"| - | # | - | - | - |\n" +
			"---------------------\n" +
			"| - | - | - | - | - |\n" +
			"---------------------\n" +
			"| - | - | - | - | # |\n" +
			"---------------------";
		assertThat(formatter.format(board)).isEqualTo(expectedConsoleFormattedBoard);
	}

	@Test
	void calculateHorizontalLineSeparator_shouldReturnEmptyString_ifZero() {
		assertThat(formatter.calculateHorizontalLineSeparator(0)).isEqualTo("");
	}

	@Test
	void calculateHorizontalLineSeparator_shouldReturnRepeatingCharacters() {
		String horizontalLineSeparator = formatter.calculateHorizontalLineSeparator(5);
		assertThat(horizontalLineSeparator.length()).isEqualTo(21);
	}

	@Test
	void queenOrEmpty_shouldReturnQueenSymbol_ifQueen() {
		assertThat(formatter.queenOrEmpty(true)).isEqualTo(SYMBOL_QUEEN);
	}

	@Test
	void queenOrEmpty_shouldReturnEmptySymbol_ifNoQueen() {
		assertThat(formatter.queenOrEmpty(false)).isEqualTo(SYMBOL_EMPTY);
	}

}