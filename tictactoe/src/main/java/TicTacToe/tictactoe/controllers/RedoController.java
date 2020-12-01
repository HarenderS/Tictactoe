package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Session;

public class RedoController extends UseCaseController {

	RedoController(Session session) {
		super(session);
	}

	void redo() {
		this.session.redo();
	}

	boolean redoable() {
		return this.session.isRedoable();
	}

}
