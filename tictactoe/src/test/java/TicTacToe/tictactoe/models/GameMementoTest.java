package TicTacToe.tictactoe.models;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import TicTacToe.tictactoe.types.Token;

public class GameMementoTest {

	private Board board;
	private Turn turn;
	
	@Before
	public void before() {
		this.board = new Board();
        this.turn = new Turn(this.board);
        this.turn.setUsers(2);
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
	public void setTurnWithSamePlayerAndGetCopyMementoTest() {
		GameMemento gameMemento1 = new GameMemento(this.board,this.turn);
		
		GameMemento gameMemento2 = new GameMemento(this.board,this.turn);
		
		assertNotEquals(this.turn.getPlayer(),gameMemento1.getTurn().getPlayer());
		assertNotEquals(this.turn.getPlayer(),gameMemento2.getTurn().getPlayer());
		assertNotEquals(gameMemento1.getTurn().getPlayer(),gameMemento2.getTurn().getPlayer());
		assertNotEquals(this.turn.getOtherPlayer(),gameMemento1.getTurn().getPlayer());
		assertNotEquals(this.turn.getOtherPlayer(),gameMemento2.getTurn().getPlayer());
	}
	
	@Test
	public void setTurnWithBoardChangedAndGetPlayerBoardCopiedMementoTest() {
		this.board.put(new Coordinate(1, 2), Token.X);
		
		GameMemento gameMemento = new GameMemento(this.board,this.turn);
		
		assertNotEquals(this.turn.getPlayer(),gameMemento.getTurn().getPlayer());
		assertNotEquals(this.board, gameMemento.getTurn().getPlayer().getBoard());
	}
}
