package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.utils.Menu;

public class PlayMenu extends Menu {

  PlayMenu(PlayController playController) {
    this.addCommand(new PlayCommand(playController));
    this.addCommand(new UndoCommand(playController));
    this.addCommand(new RedoCommand(playController));
  }

}
