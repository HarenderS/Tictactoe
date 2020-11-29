package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.types.Error;
import TicTacToe.utils.Console;

class ErrorView extends TicTacToe.tictactoe.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}

}
