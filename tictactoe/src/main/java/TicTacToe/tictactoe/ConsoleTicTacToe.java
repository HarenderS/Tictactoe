package TicTacToe.tictactoe;

import TicTacToe.tictactoe.views.View;
import TicTacToe.tictactoe.views.console.ConsoleView;

class ConsoleTicTacToe extends TicTacToe {

	@Override
	protected View createView() {
		return new ConsoleView();
	}

	public static void main(String[] args) {
		new ConsoleTicTacToe().play();
	}

}
