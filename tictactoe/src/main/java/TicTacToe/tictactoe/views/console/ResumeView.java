package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.ResumeController;
import TicTacToe.tictactoe.views.MessageView;
import TicTacToe.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}

}
