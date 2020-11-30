package TicTacToe.tictactoe.models;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import TicTacToe.tictactoe.types.Token;

public class GameRegistryTest {

	private GameRegistry registry;
	private Game game;
	
	@Before
	public void test() {
		this.game = new Game();
		this.game.createPlayers(2);
		this.registry = new GameRegistry(this.game);
	}

	@Test
	public void registerGameAndCheckValuesTest() {
		assertNull(this.game.getToken(at(0, 0)));
		this.game.putTokenPlayerFromTurn(at(0,0));
		this.registry.register();
	}
	
	@Test
	public void checkIsUndoableTest() {
		Game game1 = new Game();
		game1.createPlayers(2);
		game1.putTokenPlayerFromTurn(at(0, 0));
		GameRegistry registry1 = new GameRegistry(game1);
		registry1.register();
		assertTrue(registry1.isUndoable());
	}

	@Test
	public void checkIsNotUndoableTest() {
		GameRegistry registry1 = new GameRegistry(new Game());
		assertFalse(registry1.isUndoable());
	}
	
	@Test
	public void undoAndCheckIsCorrectUndoTest() {
		assertNull(this.game.getToken(at(0, 2)));
		this.game.putTokenPlayerFromTurn(at(0, 2));
		this.registry.register();
		assertEquals(Token.TOKEN_X, this.game.getToken(at(0, 2)));

		this.registry.undo();
		assertNull(this.game.getToken(at(0, 2)));
	}

	private Coordinate at(int row, int col) {
		return new Coordinate(row, col);
	}
}
