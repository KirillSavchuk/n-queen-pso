package lv.rtu.ks;

import lv.rtu.ks.view.Board;
import lv.rtu.ks.view.BoardConsoleFormatter;
import lv.rtu.ks.view.QueenPositions;
import lv.rtu.ks.view.QueenPositionsRandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NQueenProblemPsoApplication implements CommandLineRunner {

	@Autowired
	private QueenPositionsRandomGenerator queenPositionsRandomGenerator;

	public static void main(String[] args) {
		SpringApplication.run(NQueenProblemPsoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		QueenPositions queenPositions = new QueenPositions(new int[]{0, 1, 2});
		Board board = new Board(queenPositions);
		System.out.println(BoardConsoleFormatter.format(board));
	}

}
