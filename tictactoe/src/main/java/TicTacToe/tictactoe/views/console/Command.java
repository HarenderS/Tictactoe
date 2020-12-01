package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.PlayController;

abstract class Command extends TicTacToe.utils.Command {

  protected PlayController playController;

  protected Command(String title, PlayController playController) {
    super(title);
    this.playController = playController;
  }

}
