package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Session;

public class StartController extends UseCaseController implements AcceptorController {

	public StartController(Session session) {
		super(session);
	}

	public void setUsers(int users) {
		this.session.setUsers(users);
		this.nextState();
	}

	public int getMaxPlayers() {
		return this.session.getMaxPlayers();
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
