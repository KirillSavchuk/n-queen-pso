package lv.rtu.ks;

import lv.rtu.ks.view.Board;
import lv.rtu.ks.view.BoardConsoleFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NQueenProblemPsoApplication implements CommandLineRunner {

	@Autowired
	private BoardConsoleFormatter boardConsoleFormatter;

	public static void main(String[] args) {
		SpringApplication.run(NQueenProblemPsoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		int[] queens = new int[]{0, 0, 0, 4, 1};
		Board board = new Board(queens);
		String consoleFormattedBoard = boardConsoleFormatter.format(board);
		System.out.println(consoleFormattedBoard);
	}

}
