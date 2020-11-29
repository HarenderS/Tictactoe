package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.types.Error;
import TicTacToe.tictactoe.views.PlayerView;

class MachinePlayerView extends PlayerView {

	MachinePlayerView(PlayController playController) {
		super(playController);
	}

	@Override
	public Coordinate readCoordinateToPut() {
		Coordinate coordinate;
		Error error;
		do {
			coordinate = this.playController.generateRandomCoordinate();
			error = this.getPutCoordinateError(coordinate);
		} while (error != null);
		return coordinate;
	}

	@Override
	public Coordinate[] readCoordinatesToMove() {
		Coordinate[] coordinates = new Coordinate[2];
		Error error;
		do {
			coordinates[0] = this.playController.generateRandomCoordinate();
			error = this.getMoveOriginCoordinateError(coordinates[0]);
		} while (error != null);
		do {
			coordinates[1] = this.playController.generateRandomCoordinate();
			error = this.getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
		} while (error != null);
		return coordinates;
	}

}