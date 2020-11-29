package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Game;
import TicTacToe.tictactoe.models.State;

public class ResumeController extends Controller {

	public ResumeController(Game game, State state) {
		super(game, state);
	}

	public void resume(boolean newGame) {
		if (newGame) {
			this.game.newGame();
			this.state.reset();
		} else {
			this.state.next();
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
