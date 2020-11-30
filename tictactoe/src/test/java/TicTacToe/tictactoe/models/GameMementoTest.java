package TicTacToe.tictactoe.models;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Before;
import org.junit.Test;

import TicTacToe.tictactoe.types.PlayerType;
import TicTacToe.tictactoe.types.Token;

public class GameMementoTest {

	private Board board;
	private Player[] player;
	private Turn turn;
	
	@Before
	public void before() {
		this.board = new Board();
		this.player = new Player[2];
        this.player[0] = new Player(Token.values()[0], this.board, PlayerType.USER_PLAYER);
        this.player[1] = new Player(Token.values()[1], this.board, PlayerType.MACHINE_PLAYER);
        this.turn = new Turn(this.player);
	}
	
	@Test
	public void setBoardAndGetCopyOfBoardMementoTest() {
		GameMemento gameMemento = new GameMemento(this.board,this.turn);
		assertNotEquals(this.board,gameMemento.getBoard());
	}
}
