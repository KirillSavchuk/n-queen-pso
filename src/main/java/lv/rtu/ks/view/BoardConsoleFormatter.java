package lv.rtu.ks.view;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class BoardConsoleFormatter {

	protected static final char SYMBOL_QUEEN = '#';
	protected static final char SYMBOL_EMPTY = '-';

	public String format(Board board) {
		StringBuilder formattedBoard = new StringBuilder();
		final int boardSize = board.getBoardSize();

		final String horizontalLineSeparator = calculateHorizontalLineSeparator(boardSize);
		for (int row = 0; row < boardSize; row++) {
			formattedBoard.append(horizontalLineSeparator).append("\n");
			for (int col = 0; col < boardSize; col++) {
				formattedBoard.append(String.format("| %s ", queenOrEmpty(board.isQueen(row, col))));
			}
			formattedBoard.append("|").append("\n");
		}
		formattedBoard.append(horizontalLineSeparator);

		return formattedBoard.toString();
	}

	protected String calculateHorizontalLineSeparator(int boardSize) {
		return boardSize == 0 ? "" : StringUtils.repeat("-", boardSize * 3 + boardSize + 1);
	}

	protected char queenOrEmpty(boolean isQueen) {
		return isQueen ? SYMBOL_QUEEN : SYMBOL_EMPTY;
	}

}
