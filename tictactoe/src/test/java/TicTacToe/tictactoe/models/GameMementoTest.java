package TicTacToe.tictactoe.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
	
	@Test
	public void setTurnAndGetCopyOfTurnMementoTest() {
		GameMemento gameMemento = new GameMemento(this.board,this.turn);
		assertNotEquals(this.turn,gameMemento.getTurn());
	}
	
	@Test
	public void setTurnWithPlayerChangedAndGetCopyMementoTest() {
		GameMemento gameMemento1 = new GameMemento(this.board,this.turn);
		
		this.turn.change();
		GameMemento gameMemento2 = new GameMemento(this.board,this.turn);
		
		assertNotEquals(this.turn.getPlayer(),gameMemento1.getTurn().getPlayer());
		assertNotEquals(gameMemento1.getTurn().getPlayer(),gameMemento2.getTurn().getPlayer());
		assertEquals(this.turn.getOtherPlayer(),gameMemento1.getTurn().getPlayer());
		assertEquals(this.turn.getPlayer(),gameMemento2.getTurn().getPlayer());
	}
	
	@Test
	public void setTurnWithBoardChangedAndGetPlayerBoardChangedMementoTest() {
		this.board.put(new Coordinate(1, 2), Token.TOKEN_X);
		
		GameMemento gameMemento = new GameMemento(this.board,this.turn);
		
		assertEquals(this.turn.getPlayer(),gameMemento.getTurn().getPlayer());
		assertEquals(this.board, gameMemento.getTurn().getPlayer().getBoard());
	}
}
