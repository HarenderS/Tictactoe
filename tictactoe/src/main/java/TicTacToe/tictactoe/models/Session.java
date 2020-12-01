package TicTacToe.tictactoe.models;

import TicTacToe.tictactoe.types.Error;
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

	public void nextState() {
		this.state.nextState();
	}
	
	public void reset() {
	    this.game.reset();
	    this.state.reset();
	  }

	public Error put(Coordinate coordinate) {
		Error error = this.game.put(coordinate);
		if (error.isNull()) {
			this.registry.register();
		}
		return error;
	}

	public Error move(Coordinate origin, Coordinate target) {
		Error error = this.game.move(origin, target);
		if (error.isNull()) {
			this.registry.register();
		}
		return error;
	}

	public void undo() {
		this.registry.undo();
		if (!this.game.isUser()) {
			this.registry.undo();
		}
	}

	public boolean isUndoable() {
		return this.registry.isUndoable();
	}

	public boolean isRedoable() {
		return this.registry.isRedoable();
	}

	public void redo() {
		this.registry.redo();
	}
}
