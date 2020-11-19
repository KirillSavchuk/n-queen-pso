package lv.rtu.ks.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueenPositionsGeneratorTest {

	private final QueenPositionsGenerator generator = new QueenPositionsGenerator();

	@Test
	void generateRandom_shouldGenerateRandomQueenPositions() {
		QueenPositions randomQueenPositions = generator.generateRandom(5);

		int rowPositionSum = randomQueenPositions.stream().mapToInt(Queen::getRow).sum();
		int columnPositionSum = randomQueenPositions.stream().mapToInt(Queen::getColumn).sum();
		int conflictsSum = randomQueenPositions.stream().mapToInt(Queen::getConflicts).sum();

		assertThat(rowPositionSum).isEqualTo(10);
		assertThat(columnPositionSum).isEqualTo(10);
		assertThat(conflictsSum).isEqualTo(0);
	}

	@Test
	void randomIntArray_shouldGenerateRandomIntArray() {
		assertThat(generator.randomIntArray(5)).contains(0, 1, 2, 3, 4);
	}

	@Test
	void randomIntList_shouldGenerateRandomIntList() {
		assertThat(generator.randomIntList(5)).contains(0, 1, 2, 3, 4);
	}

	@Test
	void randomIntList_shouldReturnEmptyList_ifUpperBoundIsZero() {
		assertThat(generator.randomIntList(0)).isEmpty();
	}
}