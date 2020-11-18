package lv.rtu.ks.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lv.rtu.ks.utils.ArrayUtil.toArray;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class QueenPositionsTest {

	private final QueenPositions queenPositions = new QueenPositions();

	@Test
	void queenColumnsToQueens_shouldReturnListOfQueens() {
		List<Queen> queens = queenPositions.queenColumnsToQueens(toArray(3, 2, 0, 1));

		assertThat(queens.get(0).getRow()).isEqualTo(0);
		assertThat(queens.get(0).getColumn()).isEqualTo(3);

		assertThat(queens.get(3).getRow()).isEqualTo(3);
		assertThat(queens.get(3).getColumn()).isEqualTo(1);
	}

}