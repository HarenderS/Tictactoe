package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Session;

public class ResumeController extends UseCaseController implements AcceptorController {

	ResumeController(Session session) {
		super(session);
	}

	public void resume() {
		this.session.reset();
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
