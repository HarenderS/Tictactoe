package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.views.Message;
import TicTacToe.tictactoe.types.Error;

class PlayCommand extends Command {

	PlayCommand(PlayController playController) {
		super(Message.ACTION_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		if (!playController.isBoardComplete()) {
			this.put(playController);
		} else {
			this.move(playController);
		}
		if (playController.isTicTacToe()) {
			new TokenView(playController.getToken()).write();
			Message.PLAYER_WIN.writeln();
		}
	}

	private void put(PlayController playController) {
		Coordinate coordinate;
		Error error;
		do {
			coordinate = new CoordinateView().read(Message.COORDINATE_TO_PUT.toString());
			error = playController.put(coordinate);
			new ErrorView(error).writeln();
		} while (!error.isNull());
	}

	private void move(PlayController playController) {
		Coordinate origin;
		Coordinate target;
		Error error;
		do {
			origin = new CoordinateView().read(Message.COORDINATE_TO_REMOVE.toString());
			target = new CoordinateView().read(Message.COORDINATE_TO_MOVE.toString());
			error = playController.move(origin, target);
			new ErrorView(error).writeln();
		} while (!error.isNull());
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
