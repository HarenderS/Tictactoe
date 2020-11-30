package TicTacToe.tictactoe.models;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
		this.game.setUsers(2);
		this.registry = new GameRegistry(this.game);
	}

	@Test
	public void registerGameAndCheckValuesTest() {
		assertEquals(Token.NULL, this.game.getToken(at(0, 0)));
		this.game.put(at(0,0));
		this.registry.register();
	}
	
	@Test
	public void checkIsUndoableTest() {
		Game game1 = new Game();
		game1.setUsers(2);
		game1.put(at(0, 0));
		GameRegistry registry1 = new GameRegistry(game1);
		registry1.register();
		assertTrue(registry1.isUndoable());
	}

	@Test
	public void checkIsNotUndoableTest() {
		Game game1 = new Game();
		game1.setUsers(2);
		GameRegistry registry1 = new GameRegistry(game1);
		assertFalse(registry1.isUndoable());
	}
	
	@Test
	public void undoAndCheckIsCorrectUndoTest() {
		assertEquals(Token.NULL, this.game.getToken(at(0, 2)));
		this.game.put(at(0, 2));
		this.registry.register();
		assertEquals(Token.O, this.game.getToken(at(0, 2)));

		this.registry.undo();
		assertEquals(Token.NULL, this.game.getToken(at(0, 2)));
	}

	private Coordinate at(int row, int col) {
		return new Coordinate(row, col);
	}
}
