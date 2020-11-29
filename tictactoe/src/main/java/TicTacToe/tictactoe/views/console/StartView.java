package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.StartController;
import TicTacToe.tictactoe.models.Turn;
import TicTacToe.tictactoe.views.MessageView;
import TicTacToe.utils.PlayersDialog;
import TicTacToe.utils.WithConsoleView;

class StartView extends WithConsoleView {

    void interact(StartController startController) {
		startController.start();
		this.console.writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new PlayersDialog().read(Turn.NUM_PLAYERS);
		startController.createPlayers(numberOfUsers);
	}
}