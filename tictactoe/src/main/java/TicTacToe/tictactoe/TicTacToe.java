package TicTacToe.tictactoe;

import TicTacToe.tictactoe.controllers.Controller;
import TicTacToe.tictactoe.controllers.Logic;
import TicTacToe.tictactoe.views.View;

public abstract class TicTacToe {

    private Logic logic;

    private View view;

    protected TicTacToe() {
        this.logic = new Logic();
		this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        Controller controller;
		do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
		} while (controller != null);
    }
}