package TicTacToe.tictactoe.views;

import TicTacToe.tictactoe.controllers.AcceptorController;
import TicTacToe.tictactoe.controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor {

    public void interact(AcceptorController controller) {
		controller.accept(this);
	}
}