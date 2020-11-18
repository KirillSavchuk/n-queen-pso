package lv.rtu.ks.pso;

import lombok.Getter;
import lombok.Setter;
import lv.rtu.ks.view.QueenPositions;

@Getter
@Setter
public class BoardParticle implements Comparable<BoardParticle> {

	private QueenPositions queenPositions;
	private float velocity;
	private int conflicts;

	public BoardParticle(QueenPositions queenPositions) {
		this.queenPositions = queenPositions;
		this.velocity = 0f;
		this.conflicts = Integer.MAX_VALUE;
	}

	@Override
	public int compareTo(BoardParticle boardParticle) {
		return this.conflicts - boardParticle.getConflicts();
	}

}
