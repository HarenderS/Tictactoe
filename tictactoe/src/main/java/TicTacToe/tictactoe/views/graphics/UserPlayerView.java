package TicTacToe.tictactoe.views.graphics;

import javax.swing.JOptionPane;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.types.Error;
import TicTacToe.tictactoe.views.ErrorView;
import TicTacToe.tictactoe.views.MessageView;
import TicTacToe.tictactoe.views.PlayerView;

import java.awt.Container;

class UserPlayerView extends PlayerView {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
    static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

    CoordinatePutView coordinatePutView;
    CoordinateMoveView coordinateMoveView;

    UserPlayerView(PlayController playController, boolean isMovement, Container panel) {
        super(playController);
        if (isMovement) {
            this.coordinateMoveView = new CoordinateMoveView(playController);
            panel.add(this.coordinateMoveView, new Constraints(0, 1, 3, 1));
        } else {
            this.coordinatePutView = new CoordinatePutView(playController);
            panel.add(this.coordinatePutView, new Constraints(0, 1, 3, 1));
        }
    }

    @Override
    public Coordinate readCoordinateToPut() {
        Coordinate coordinate = new Coordinate();
        Error error;
        do {
            System.out.println("");
            if (this.coordinatePutView.getCoordinate() != null) {
                coordinate = this.coordinatePutView.getCoordinate();
                error = getPutCoordinateError(coordinate);
                if (error != null) {
                    JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal() - 1],
                            MessageView.ERROR.getMessage(), JOptionPane.WARNING_MESSAGE);
                    this.coordinatePutView.resetCoordinate();
                }
            }
        } while (this.coordinatePutView.getCoordinate() == null);
        return coordinate;
    }

    @Override
    public Coordinate[] readCoordinatesToMove() {
        Coordinate[] coordinates = new Coordinate[2];
        Error error;
        do {
            System.out.println("");
            if (this.coordinateMoveView.getCoordinates() != null) {
                coordinates = this.coordinateMoveView.getCoordinates();
                error = getMoveOriginCoordinateError(coordinates[0]);
                if (error != null) {
                    JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal() - 1],
                            MessageView.ERROR.getMessage(), JOptionPane.WARNING_MESSAGE);
                    this.coordinateMoveView.resetCoordinates();
                }
                error = getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
                if (error != null) {
                    JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal() - 1],
                            MessageView.ERROR.getMessage(), JOptionPane.WARNING_MESSAGE);
                    this.coordinateMoveView.resetCoordinates();
                }
            }
        } while (this.coordinateMoveView.getCoordinates() == null);
        return coordinates;
    }
}