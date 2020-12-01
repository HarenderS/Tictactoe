package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.ResumeController;
import TicTacToe.tictactoe.views.Message;
import TicTacToe.utils.YesNoDialog;

class ResumeView {

	boolean interact(ResumeController resumeController) {
		boolean isResumed = new YesNoDialog().read(Message.RESUME.toString());
		if (isResumed){
			resumeController.resume();
		} else {
			resumeController.nextState();
		}
		return isResumed;
	}

}
