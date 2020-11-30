package TicTacToe.tictactoe;

import TicTacToe.tictactoe.views.console.View;

class ConsoleTicTacToe extends TicTacToe {

	@Override
	protected View createView(){
		return new View();
	}

	public static void main(String[] args) {
		new ConsoleTicTacToe().play();
	}

}