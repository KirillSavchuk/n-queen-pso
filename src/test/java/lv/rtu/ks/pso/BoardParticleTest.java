package lv.rtu.ks.pso;

import lv.rtu.ks.view.QueenPositions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardParticleTest {

	@Test
	void constructor_shouldReturnInitialBoard() {
		BoardParticle boardParticle = new BoardParticle(new QueenPositions());
		assertThat(boardParticle.getVelocity()).isEqualTo(0f);
		assertThat(boardParticle.getConflicts()).isEqualTo(Integer.MAX_VALUE);
	}

	@Test
	void compareTo_shouldCompareByConflicts() {
		BoardParticle firstBoardParticle = new BoardParticle(new QueenPositions());
		BoardParticle secondBoardParticle = new BoardParticle(new QueenPositions());
		firstBoardParticle.setConflicts(10);
		secondBoardParticle.setConflicts(5);

		assertThat(firstBoardParticle.compareTo(secondBoardParticle)).isEqualTo(5);
	}

}