package TicTacToe.tictactoe.views.graphics;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import TicTacToe.tictactoe.types.Error;
import TicTacToe.tictactoe.views.ErrorView;
import TicTacToe.tictactoe.views.MessageView;

@SuppressWarnings("serial")
class ChoosePlayersView extends JPanel implements ActionListener, KeyListener {

	private static final String ACCEPT = "Ok";

	private final JLabel label;

	private final JTextField textField;

	private final JButton button;

	private String playersNumber;

	ChoosePlayersView(final JRootPane rootPane) {
		this.setLayout(new GridBagLayout());
		this.label = new JLabel(MessageView.CHOOSE_PLAYERS.getMessage());
		this.button = new JButton(ChoosePlayersView.ACCEPT);
		this.textField = new JTextField(10);
		this.resetPlayersNumber();
		this.add(label, new Constraints(0, 0, 1, 1));
		this.add(textField, new Constraints(0, 1, 1, 1));
		this.add(button, new Constraints(0, 2, 1, 1));
		rootPane.setDefaultButton(this.button);
		this.button.addActionListener(this);
		this.button.addKeyListener(this);
	}

	void resetPlayersNumber() {
		this.playersNumber = null;
	}

	String getPlayersNumber() {
		return this.playersNumber;
	}

	public void actionPerformed(final ActionEvent event) {
		String usersInsertedText = this.textField.getText();
		int usersInserted = Integer.parseInt(usersInsertedText);
		if (usersInserted >= 0 && usersInserted < 3) {
			this.playersNumber = usersInsertedText;
		} else {
			JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[Error.USERS_ERROR.ordinal()],
					MessageView.ERROR.getMessage(), JOptionPane.WARNING_MESSAGE);
		}
		this.textField.setText("");
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