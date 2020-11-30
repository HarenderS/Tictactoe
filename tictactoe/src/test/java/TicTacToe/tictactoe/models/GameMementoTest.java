package TicTacToe.tictactoe.models;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

public class GameMementoTest {

	
	@Test
	public void getBoardNullMementoTest() {
		GameMemento gameMemento = new GameMemento(null);
		assertNull(gameMemento.getBoard());
		
	}
	
	@Test
	public void getTurnNullMementoTest() {
		GameMemento gameMemento = new GameMemento(new Board());
		assertNull(gameMemento.getTurn());
		
	}
	
	@Test
	public void setBoardAndGetNotNullMementoTest() {
		GameMemento gameMemento = new GameMemento(new Board());
		assertNotNull(gameMemento.getBoard());
		
	}
}
