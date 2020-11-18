package lv.rtu.ks.view;

import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@ToString
public class QueenPositions extends LinkedList<Queen> {

	public QueenPositions(Queen... positions) {
		this.addAll(Arrays.asList(positions));
	}

	public QueenPositions(int[] queenColumnPositions) {
		this.addAll(this.queenColumnsToQueens(queenColumnPositions));
	}

	protected List<Queen> queenColumnsToQueens(int[] queenColumnPositions) {
		List<Queen> queenPositions = new LinkedList<>();
		for (int position = 0; position < queenColumnPositions.length; position++) {
			int columnPosition = queenColumnPositions[position];
			queenPositions.add(new Queen(position, columnPosition));
		}
		return queenPositions;
	}

}
