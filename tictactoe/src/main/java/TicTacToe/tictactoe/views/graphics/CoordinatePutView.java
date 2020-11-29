package TicTacToe.tictactoe.views.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.models.Coordinate;
import TicTacToe.tictactoe.types.Error;
import TicTacToe.tictactoe.views.ErrorView;
import TicTacToe.tictactoe.views.MessageView;

@SuppressWarnings("serial")
public class CoordinatePutView extends CoordinateView {

	private Coordinate coordinate;

	CoordinatePutView(PlayController playController) {
		super(playController);
		this.resetCoordinate();
		this.titleLabel = new JLabel(ENTER_COORDINATE_TO_PUT);
		this.add(titleLabel, new Constraints(0, 0, 1, 1));
		this.button = new JButton(CoordinateView.ACCEPT);
		this.add(button, new Constraints(0, 5, 1, 1));
		this.button.addActionListener(this);
		this.button.addKeyListener(this);
	}

	void resetCoordinate() {
		this.coordinate = null;
	}

	Coordinate getCoordinate() {
		return this.coordinate;
	}

	public void actionPerformed(final ActionEvent event) {
		int coordinateRow = Integer.parseInt(this.textFieldRow.getText()) - 1;
		int coordinateColumn = Integer.parseInt(this.textFieldColumn.getText()) - 1;
		Coordinate coordinateInserted = new Coordinate(coordinateRow, coordinateColumn);
		if (this.playController.isCoordinateValid(coordinateInserted)) {
			this.coordinate = coordinateInserted;
		} else {
			JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[Error.WRONG_COORDINATES.ordinal()],
					MessageView.ERROR.getMessage(), JOptionPane.WARNING_MESSAGE);
		}
		this.textFieldRow.setText("");
		this.textFieldColumn.setText("");
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}