package lv.rtu.ks.pso.exception;

import lv.rtu.ks.pso.BoardParticle;

import static java.lang.String.format;

public class MaxRunIterationCountExceededException extends PracticalSwarmOptimizationException {

	public MaxRunIterationCountExceededException(BoardParticle bestBoardParticle, int maxIterationCount) {
		super(bestBoardParticle, format("Exceeded Max Iteration Count: %s", maxIterationCount));
	}

}
