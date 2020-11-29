package TicTacToe.tictactoe.views;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.types.Error;

public abstract class PlayerView {

    protected PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }
  
    public abstract Coordinate readCoordinateToPut();
    public abstract Coordinate[] readCoordinatesToMove();

    public Error getPutCoordinateError(Coordinate coordinate) {
        return this.playController.getPutCoordinateError(coordinate);
	}

	public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		return this.playController.getMoveOriginCoordinateError(originCoordinate);
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.playController.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}
}