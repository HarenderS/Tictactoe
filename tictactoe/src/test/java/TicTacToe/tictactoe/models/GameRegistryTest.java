package TicTacToe.tictactoe.models;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GameRegistryTest {

	private GameRegistry registry;
	private Game game;
	
	@Before
	public void test() {
		this.game = new Game();
		this.registry = new GameRegistry(this.game);
	}

	@Test(expected = Exception.class)
	public void registerGameAndCheckValuesTest() {
		assertNull(this.game.getToken(at(0, 0)));
		this.game.putTokenPlayerFromTurn(at(0,0));
		this.registry.register();
	}
	
	
	private Coordinate at(int row, int col) {
		return new Coordinate(row, col);
	}
}
