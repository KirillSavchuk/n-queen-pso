package lv.rtu.ks.pso;

import lv.rtu.ks.pso.exception.MaxRunIterationCountExceededException;
import lv.rtu.ks.pso.exception.MaxRunTimeExceededException;
import lv.rtu.ks.view.Queen;
import lv.rtu.ks.view.QueenPositions;
import lv.rtu.ks.view.QueenPositionsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PracticalSwarmOptimizationTest {

	@Mock
	private QueenPositionsGenerator queenPositionsGenerator;

	@Mock
	private BoardParticleDiagonalConflictCalculator conflictCalculator;

	@InjectMocks
	private PracticalSwarmOptimization pso;


	private PsoOptions options;

	@BeforeEach
	void setUp() {
		options = PsoOptions.builder()
			.boardSize(1)
			.particleCount(2)
			.inertiaWeight(2)
			.individualLearningFactor(1.5f)
			.swarmLearningFactor(2.5f)
			.minConflicts(2)
			.maxIterations(500)
			.maxRunTime(10000)
			.build();
		when(queenPositionsGenerator.generateRandom(anyInt()))
			.thenReturn(new QueenPositions(new Queen(0, 0)));
		when(conflictCalculator.calculateQueensConflicts(any(QueenPositions.class)))
			.thenReturn(100);
	}

	@Test
	void run_shouldThrowMaxRunIterationCountExceededException_onCondition() {
		final int MAX_ITERATIONS = 1;
		options.setMaxIterations(MAX_ITERATIONS);

		MaxRunIterationCountExceededException exception = assertThrows(MaxRunIterationCountExceededException.class, () -> pso.run(options));
		assertThat(exception.getBestBoardParticle()).isInstanceOf(BoardParticle.class);
		assertThat(exception.getMessage()).isEqualTo(format("Exceeded Max Iteration Count: %s", MAX_ITERATIONS));
	}

	@Test
	void run_shouldThrowMaxRunTimeExceededException_onCondition() {
		final int MAX_RUN_TIME = 10;
		options.setMaxRunTime(MAX_RUN_TIME);

		MaxRunTimeExceededException exception = assertThrows(MaxRunTimeExceededException.class, () -> pso.run(options));
		assertThat(exception.getBestBoardParticle()).isInstanceOf(BoardParticle.class);
		assertThat(exception.getMessage()).isEqualTo(format("Exceeded Max Run time: %s ms", MAX_RUN_TIME));
	}

	@Test
	void initRandomBoardParticles() {
	}

	@Test
	void calculateQueensConflicts() {
	}

	@Test
	void sortAndFindBestParticle() {
	}

	@Test
	void runTimeExceededAllowedMaxRunTime() {
	}

	@Test
	void bestBoardParticleSuitsMinConflictCount() {
	}

}