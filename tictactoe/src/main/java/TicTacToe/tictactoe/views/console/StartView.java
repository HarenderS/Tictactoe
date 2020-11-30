package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.StartController;
import TicTacToe.tictactoe.views.Message;
import TicTacToe.utils.LimitedIntDialog;

class StartView {

	void interact(StartController startController) {
		Message.TITTLE.writeln();
		int users = new LimitedIntDialog(0, 
		startController.getMaxPlayers()).read(Message.NUMBER_PLAYERS.toString());
		startController.setUsers(users);
		new GameView(startController).write();
	}

}