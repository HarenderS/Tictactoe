package TicTacToe.tictactoe.views.console;

import TicTacToe.utils.Console;
import TicTacToe.tictactoe.types.Error;

class ErrorView extends TicTacToe.tictactoe.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		if (!error.isNull()){
			Console.instance().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
		}
	}

}
