package TicTacToe.tictactoe;

import TicTacToe.tictactoe.views.View;
import TicTacToe.tictactoe.views.graphics.GraphicsView;

public class GraphicsTicTacToe extends TicTacToe {

	@Override
	protected View createView() {
		return new GraphicsView();
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}
}