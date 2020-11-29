package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.controllers.ResumeController;
import TicTacToe.tictactoe.controllers.StartController;
import TicTacToe.tictactoe.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private PlayView playView;

	private ResumeView resumeView;

	public ConsoleView() {
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
	}

	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}
	
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}
	
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}
}