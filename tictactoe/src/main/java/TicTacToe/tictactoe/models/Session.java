package TicTacToe.tictactoe.models;

import TicTacToe.tictactoe.types.StateValue;
import TicTacToe.tictactoe.types.Token;

public class Session {

	private Game game;
	private GameRegistry registry;
	private State state;

	public Session() {
		this.state = new State();
		this.game = new Game();
	}

	public void setUsers(int users) {
		this.game.setUsers(users);
		this.registry = new GameRegistry(this.game);
	}

	public int getMaxPlayers() {
		return this.game.getMaxPlayers();
	}

	public Token getToken() {
		return this.game.getToken();
	}

	public Token getToken(Coordinate coordinate) {
		return this.game.getToken(coordinate);
	}

	public boolean isBoardComplete() {
		return this.game.isBoardComplete();
	}

	public StateValue getValueState() {
		return this.state.getValueState();
	}

	public void next() {
		this.state.next();
	}
}
