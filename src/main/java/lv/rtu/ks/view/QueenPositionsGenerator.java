package lv.rtu.ks.view;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class QueenPositionsGenerator {

	public QueenPositions generateRandom(int queenCount) {
		return new QueenPositions(this.randomIntArray(queenCount));
	}

	protected int[] randomIntArray(int queenCount) {
		return this.randomIntList(queenCount).stream().mapToInt(i -> i).toArray();
	}

	protected List<Integer> randomIntList(int upperBound) {
		List<Integer> uniqueNumbers = IntStream.range(0, upperBound).boxed().collect(Collectors.toList());
		Collections.shuffle(uniqueNumbers);
		return uniqueNumbers;
	}

}
