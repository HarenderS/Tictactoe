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
		assertEquals(Token.X, this.game.getToken(at(0, 2)));

		this.registry.undo();
		assertEquals(Token.NULL, this.game.getToken(at(0, 2)));
	}
	
	@Test
	public void checkIsRedoableTest() {
		Game game1 = new Game();
		game1.setUsers(2);
		game1.put(at(0, 0));
		game1.put(at(0, 1));
		game1.put(at(1, 1));
		GameRegistry registry1 = new GameRegistry(game1);
		registry1.register();
		assertEquals(Token.X, game1.getToken(at(1, 1)));
		registry1.undo();
		assertEquals(Token.NULL, game1.getToken(at(0, 2)));
		
		assertTrue(registry1.isRedoable());
	}
	
	@Test
	public void checkIsNotRedoableTest() {
		Game game1 = new Game();
		game1.setUsers(2);
		GameRegistry registry1 = new GameRegistry(game1);
		assertFalse(registry1.isRedoable());
	}
	
	@Test
	public void redoAndCheckIsCorrectRedoTest() {
		assertEquals(Token.NULL, this.game.getToken(at(1, 1)));
		this.game.put(at(1, 1));
		this.registry.register();
		assertEquals(Token.X, this.game.getToken(at(1, 1)));
		this.registry.undo();
		assertEquals(Token.NULL, this.game.getToken(at(1, 1)));
		this.registry.redo();
		assertEquals(Token.X, this.game.getToken(at(1, 1)));
		
	}

	private Coordinate at(int row, int col) {
		return new Coordinate(row, col);
	}
}
