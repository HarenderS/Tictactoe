package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.models.Game;
import TicTacToe.tictactoe.models.State;
import TicTacToe.tictactoe.types.Token;
import TicTacToe.tictactoe.types.Error;

public class PlayController extends UseCaseController {

	public PlayController(Game game, State state) {
		super(game, state);
	}

	public boolean isBoardComplete() {
		return this.game.isBoardComplete();
	}

	public boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}

	public Token getToken() {
		return this.game.getToken();
	}

	public boolean isUser() {
		return this.game.isUser();
	}

	public Error put(Coordinate coordinate) {
		Error error = this.game.put(coordinate);
		if (error.isNull() && this.game.isTicTacToe()) {
			this.state.nextState();
		}
		return error;
	}

	public Error move(Coordinate origin, Coordinate target) {
		Error error = this.game.move(origin, target);
		if (error.isNull() && this.game.isTicTacToe()) {
			this.state.nextState();
		}
		return error;
	}

	public Error isCoordinateValid(Coordinate coordinate) {
		return coordinate.isValid();
	}

	public boolean isEmptyToken(Coordinate coordinate) {
		return this.game.getToken(coordinate) == Token.NULL;
	}
	
	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}
	
	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}
	

}
