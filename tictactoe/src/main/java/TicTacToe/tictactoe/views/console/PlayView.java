package TicTacToe.tictactoe.views.console;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.types.PlayerType;
import TicTacToe.tictactoe.views.PlayerView;

class PlayView {

    void interact(PlayController playController) {
        new BoardView(playController).write();
        PlayerView playerView = playController.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
                ? new UserPlayerView(playController)
                : new MachinePlayerView(playController);
        if (!playController.isBoardComplete()) {
            Coordinate coordinate = playerView.readCoordinateToPut();
            playController.putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            playController.moveTokenPlayerFromTurn(coordinates[0], coordinates[1]);
        }
        if (playController.isTicTacToe()) {
            new BoardView(playController).write();
            new ResultView().writeln(playController.getValueFromTurn());
            playController.continueState();
        } else {
            playController.changeTurn();
        }
    }
}