package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.ControllerVisitor;
import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.controllers.ResumeController;
import TicTacToe.tictactoe.controllers.StartController;
import TicTacToe.tictactoe.controllers.UseCaseController;

public class View extends TicTacToe.tictactoe.views.View implements ControllerVisitor {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View() {
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void interact(UseCaseController controller) {
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

	@Override
	public void visit(PlayController playController) {
		this.playView.interact(playController);	}

	@Override
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

}