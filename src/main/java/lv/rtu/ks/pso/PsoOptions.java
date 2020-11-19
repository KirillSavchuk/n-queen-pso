package lv.rtu.ks.pso;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PsoOptions {

	private int boardSize;
	private int particleCount;
	private float inertiaWeight;
	private float individualLearningFactor;
	private float swarmLearningFactor;
	private int minConflicts;
	private int maxIterations;
	private long maxRunTime;

}
