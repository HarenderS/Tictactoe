package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.types.Error;
import TicTacToe.tictactoe.views.MessageView;
import TicTacToe.utils.WithConsoleView;

class CoordinateView extends WithConsoleView {

    PlayController playController;

    CoordinateView(PlayController playController) {
        this.playController = playController;
    }

    Coordinate read(String title) {
        Coordinate coordinate;
        do {
			this.console.writeln(title);
            int row = this.console.readInt(MessageView.READ_ROW.getMessage()) - 1;
            int column = this.console.readInt(MessageView.READ_COLUMN.getMessage()) - 1;
            coordinate = new Coordinate(row, column);
            assert playController.isCoordinateValid(coordinate);
            if (!this.playController.isCoordinateValid(coordinate)) {
                new ErrorView(Error.WRONG_COORDINATES).writeln();
            }
        } while (!this.playController.isCoordinateValid(coordinate));
        return coordinate;
    }
}