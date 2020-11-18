package lv.rtu.ks.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Queen {

	int row;
	int column;

	@Setter
	int conflicts;

	public Queen(int row, int column) {
		this(row, column, 0);
	}

}
