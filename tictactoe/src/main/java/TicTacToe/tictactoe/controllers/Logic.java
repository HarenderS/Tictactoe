package TicTacToe.tictactoe.controllers;

import java.util.HashMap;
import java.util.Map;

import TicTacToe.tictactoe.models.Game;
import TicTacToe.tictactoe.models.State;
import TicTacToe.tictactoe.types.StateValue;

public class Logic {

  private Game game;
  private State state;
  private Map<StateValue, UseCaseController> controllers;

  public Logic() {
    this.state = new State();
    this.game = new Game();
    this.controllers = new HashMap<StateValue, UseCaseController>();
    this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
    this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
    this.controllers.put(StateValue.RESUME, new ResumeController(this.game, this.state));
    this.controllers.put(StateValue.EXIT, null);
  }

  public UseCaseController getController() {
    return this.controllers.get(this.state.getValueState());
  }

}
