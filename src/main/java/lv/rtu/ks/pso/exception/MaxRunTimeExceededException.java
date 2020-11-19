package lv.rtu.ks.pso.exception;

import lv.rtu.ks.pso.BoardParticle;

import static java.lang.String.format;

public class MaxRunTimeExceededException extends PracticalSwarmOptimizationException {

	public MaxRunTimeExceededException(BoardParticle bestBoardParticle, long maxRunTime) {
		super(bestBoardParticle, format("Exceeded Max Run time: %s ms", maxRunTime));
	}

}
