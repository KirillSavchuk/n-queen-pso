package lv.rtu.ks.pso;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.rtu.ks.pso.exception.MaxRunIterationCountExceededException;
import lv.rtu.ks.pso.exception.MaxRunTimeExceededException;
import lv.rtu.ks.view.QueenPositions;
import lv.rtu.ks.view.QueenPositionsGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PracticalSwarmOptimization {

	private final QueenPositionsGenerator queenPositionsGenerator;
	private final BoardParticleDiagonalConflictCalculator conflictCalculator;

	public BoardParticle run(PsoOptions options) throws MaxRunTimeExceededException, MaxRunIterationCountExceededException {
		final int minConflicts = options.getMinConflicts();

		List<BoardParticle> boardParticles = initRandomBoardParticles(options.getParticleCount(), options.getBoardSize());

		final long maxRunTime = options.getMaxRunTime();
		final long runStartTime = System.currentTimeMillis();
		final int maxIterationCount = options.getMaxIterations();

		BoardParticle bestBoardParticle = new BoardParticle(null);
		for (int i = 0; i < maxIterationCount; i++) {
			if (runTimeExceededAllowedMaxRunTime(runStartTime, maxRunTime)) {
				throw new MaxRunTimeExceededException(bestBoardParticle, maxRunTime);
			}

			this.calculateQueensConflicts(boardParticles);
			bestBoardParticle = this.findBestBoardParticle(bestBoardParticle, boardParticles);
			if (bestBoardParticleSuitsMinConflictCount(bestBoardParticle, minConflicts)) {
				return bestBoardParticle;
			}


		}

		if (!bestBoardParticleSuitsMinConflictCount(bestBoardParticle, minConflicts)) {
			throw new MaxRunIterationCountExceededException(bestBoardParticle, maxIterationCount);
		}
		return bestBoardParticle;
	}

	protected List<BoardParticle> initRandomBoardParticles(int particlesCount, int boardSize) {
		List<BoardParticle> boardParticles = new ArrayList<>();
		for (int i = 0; i < particlesCount; i++) {
			boardParticles.add(new BoardParticle(queenPositionsGenerator.generateRandom(boardSize)));
		}
		return boardParticles;
	}

	protected void calculateQueensConflicts(List<BoardParticle> particles) {
		for (BoardParticle particle : particles) {
			QueenPositions queenPositions = particle.getQueenPositions();
			particle.setConflicts(conflictCalculator.calculateQueensConflicts(queenPositions));
		}
		Collections.sort(particles);
	}

	protected BoardParticle findBestBoardParticle(BoardParticle bestParticle, List<BoardParticle> particles) {
		for (BoardParticle particle : particles) {
			if (particle.compareTo(bestParticle) > 0) {
				bestParticle = particle;
			}
		}
		return bestParticle;
	}

	protected void calculateVelocity(List<BoardParticle> boardParticles) {
		for (BoardParticle particle : boardParticles) {
			QueenPositions queenPositions = particle.getQueenPositions();
			particle.setConflicts(conflictCalculator.calculateQueensConflicts(queenPositions));
		}
	}

	protected boolean runTimeExceededAllowedMaxRunTime(long runStartTime, long maxRunTime) {
		return System.currentTimeMillis() - runStartTime > maxRunTime;
	}

	protected boolean bestBoardParticleSuitsMinConflictCount(BoardParticle particle, int minConflicts) {
		return particle.getConflicts() < minConflicts;
	}

}
