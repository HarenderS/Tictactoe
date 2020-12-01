package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Session;

public class UndoController extends UseCaseController {

	UndoController(Session session) {
		super(session);
	}

	void undo() {
		this.session.undo();
	}

	boolean undoable() {
		return this.session.isUndoable();
	}

}
