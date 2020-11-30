package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.utils.Console;
import TicTacToe.tictactoe.types.Error;

public class CoordinateView {

    public Coordinate read(String title) {
        Console console = Console.instance();
        Coordinate coordinate;
        Error error;
        do {
			console.writeln(title);
            int row = console.readInt("Row: ") - 1;
            int column = console.readInt("Column: ") - 1;
            coordinate = new Coordinate(row, column);
            error = coordinate.isValid();
            new ErrorView(error).writeln();
        } while (!error.isNull());
        return coordinate;
    }

}