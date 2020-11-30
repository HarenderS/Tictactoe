package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.UseCaseController;
import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.views.Message;

class GameView {
    
  private UseCaseController controller;

  GameView(UseCaseController controller) {
    this.controller = controller;
  }

	void write() {
		Message.SEPARATOR.writeln();
		for (int i = 0; i<Coordinate.DIMENSION; i++) {
			Message.VERTICAL_LINE_LEFT.write();
			for (int j = 0; j<Coordinate.DIMENSION; j++) {
				new TokenView(this.controller.getToken(new Coordinate(i, j))).write();;
				Message.VERTICAL_LINE_CENTERED.write();
			}
			Message.VERTICAL_LINE_RIGHT.writeln();
		}
		Message.SEPARATOR.writeln();
	}

}