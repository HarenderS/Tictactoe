package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.models.Game;
import TicTacToe.tictactoe.models.State;
import TicTacToe.tictactoe.types.Token;

public abstract class UseCaseController {

	protected Game game;
	protected State state;

	UseCaseController(Game game, State state) {
		this.game = game;
		this.state = state;
	}

	public Token getToken(Coordinate coordinate) {
		return this.game.getToken(coordinate);
	}

	public void nextState() {
		this.state.nextState();
	}

	public abstract void accept(ControllerVisitor controllerVisitor);

}
