package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.models.Session;
import TicTacToe.tictactoe.types.Token;
import TicTacToe.tictactoe.types.Error;

public class ActionController extends UseCaseController {

	public ActionController(Session session) {
		super(session);
	}

	public boolean isBoardComplete() {
		return this.session.isBoardComplete();
	}

	public boolean isTicTacToe() {
		return this.session.isTicTacToe();
	}

	public Token getToken() {
		return this.session.getToken();
	}

	public boolean isUser() {
		return this.session.isUser();
	}

	public Error put(Coordinate coordinate) {
		Error error = this.session.put(coordinate);
		if (error.isNull() && this.session.isTicTacToe()) {
			this.session.nextState();
		}
		return error;
	}

	public Error move(Coordinate origin, Coordinate target) {
		Error error = this.session.move(origin, target);
		if (error.isNull() && this.session.isTicTacToe()) {
			this.session.nextState();
		}
		return error;
	}

	public Error isCoordinateValid(Coordinate coordinate) {
		return coordinate.isValid();
	}

	public boolean isEmptyToken(Coordinate coordinate) {
		return this.session.getToken(coordinate) == Token.NULL;
	}

	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

}
