package lv.rtu.ks.pso;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PsoOptions {

	private int boardSize;
	private int particleCount;
	private int inertiaWeight;
	private int individualLearningFactor;
	private int swarmLearningFactor;
	private int minConflicts;
	private int maxIterations;
	private long maxRunTime;

}
