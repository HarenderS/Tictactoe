package TicTacToe.tictactoe.models;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

public class GameMementoTest {

	
	@Test
	public void getBoardNullMementoTest() {
		GameMemento gameMemento = new GameMemento();
		assertNull(gameMemento.getBoard());
		
	}
	
}
