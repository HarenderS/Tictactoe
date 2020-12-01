package TicTacToe.tictactoe.controllers;

import TicTacToe.tictactoe.models.Game;
import TicTacToe.tictactoe.models.State;

public class StartController extends UseCaseController {

  public StartController(Game game, State state) {
    super(game, state);
  }

  public void setUsers(int users) {
    this.game.setUsers(users);
    this.state.nextState();
  }

  public int getMaxPlayers() {
    return this.game.getMaxPlayers();
  }

  @Override
  public void accept(ControllerVisitor controllerVisitor) {
    controllerVisitor.visit(this);
  }

}
