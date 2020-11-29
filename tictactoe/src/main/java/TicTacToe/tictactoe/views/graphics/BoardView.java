package TicTacToe.tictactoe.views.graphics;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.views.MessageView;

@SuppressWarnings("serial")
class BoardView extends JPanel {

    BoardView(PlayController playController) {
        this.setLayout(new GridBagLayout());
        this.add(new JLabel(MessageView.SEPARATOR.getMessage()), new Constraints(0, 0, 1, 1));
        for (int i = 0; i < playController.getCoordinateDimension(); i++) {
            this.printRowBoard(playController, i);
        }
        this.add(new JLabel(MessageView.SEPARATOR.getMessage()), new Constraints(0, 4, 1, 1));
    }

	private void printRowBoard(PlayController playController, int row) {
        String boardRowToPresent = "";
        boardRowToPresent += MessageView.VERTICAL_LINE_LEFT.getMessage();
        for (int j = 0; j < playController.getCoordinateDimension(); j++) {
            boardRowToPresent += this.getSquareBoardText(playController, new Coordinate(row, j));
        }
        JLabel label = new JLabel(boardRowToPresent);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, new Constraints(0, row + 1, 10, 1));
}

	private String getSquareBoardText(PlayController playController, Coordinate coordinate) {
        String squareBoardToPresent = "";
		if (playController.isEmptyToken(coordinate)) {
            squareBoardToPresent += MessageView.EMPTY.getMessage();
        } else {
            squareBoardToPresent += playController.getTokenChar(coordinate);
        }
        squareBoardToPresent += MessageView.VERTICAL_LINE_CENTERED.getMessage();
        return squareBoardToPresent;
	}
}