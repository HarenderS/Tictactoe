package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.models.Session;
import TicTacToe.tictactoe.types.Token;

public abstract class UseCaseController {

	protected Session session;

	UseCaseController(Session session) {
		this.session = session;
	}
	
	public void nextState() {
		this.session.nextState();
	}

	public Token getToken(Coordinate coordinate) {
		return this.session.getToken(coordinate);
	}

}
