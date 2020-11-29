package TicTacToe.tictactoe.views;

import TicTacToe.tictactoe.controllers.Controller;
import TicTacToe.tictactoe.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {

    public void interact(Controller controller) {
		controller.accept(this);
	}
}