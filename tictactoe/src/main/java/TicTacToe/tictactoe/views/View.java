package TicTacToe.tictactoe.views;


import TicTacToe.tictactoe.controllers.ControllerVisitor;
import TicTacToe.tictactoe.controllers.UseCaseController;

public abstract class View implements ControllerVisitor {

    public void interact(UseCaseController controller) {
		controller.accept(this);
	}
}