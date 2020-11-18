package lv.rtu.ks.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueenTest {

	private Queen queen;

	@BeforeEach
	void setUp() {
		queen = new Queen(2, 3);
	}


	@Test
	void constructor_shouldInitializeQueenWithZeroConflicts() {
		assertThat(queen.getConflicts()).isZero();
	}

	@Test
	void constructor_shouldInitializeQueenWithCorrectRowAndColumn() {
		assertThat(queen.getRow()).isEqualTo(2);
		assertThat(queen.getColumn()).isEqualTo(3);
	}

	@Test
	void setConflicts_shouldSetConflict() {
		queen.setConflicts(10);
		assertThat(queen.getConflicts()).isEqualTo(10);
	}
}