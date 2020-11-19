package lv.rtu.ks.pso.exception;

import lombok.Getter;
import lv.rtu.ks.pso.BoardParticle;

@Getter
public class PracticalSwarmOptimizationException extends Exception {

	private final BoardParticle bestBoardParticle;

	public PracticalSwarmOptimizationException(BoardParticle bestBoardParticle, String errorMsg) {
		super(errorMsg);
		this.bestBoardParticle = bestBoardParticle;
	}

}
