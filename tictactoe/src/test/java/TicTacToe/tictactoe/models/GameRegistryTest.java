package TicTacToe.tictactoe.models;

import org.junit.Before;
import org.junit.Test;

public class GameRegistryTest {

	private GameRegistry registry;
	private Game game;
	
	@Before
	public void test() {
		this.game = new Game();
		this.registry = new GameRegistry();
	}

	@Test
	public void registerGameAndCheckValuesTest() {
		this.registry.register();
	}
}
