package TicTacToe.tictactoe.views.graphics;

import javax.swing.JOptionPane;

import TicTacToe.tictactoe.views.MessageView;

class ResumeDialog {

	private boolean newGame;

	ResumeDialog() {
		this.newGame = (JOptionPane.showConfirmDialog(null, MessageView.RESUME.getMessage(),
				MessageView.START_GAME.getMessage(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}

	boolean isNewGame() {
		return this.newGame;
	}

}
