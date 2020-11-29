package TicTacToe.tictactoe.views.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import TicTacToe.tictactoe.controllers.PlayController;
import TicTacToe.tictactoe.views.MessageView;

@SuppressWarnings("serial")
public abstract class CoordinateView extends JPanel implements ActionListener, KeyListener {

	protected static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
	protected static final String ACCEPT = "Ok";

	protected final JLabel labelRow;
	protected final JLabel labelColumn;
	protected JLabel titleLabel;

	protected final JTextField textFieldRow;
	protected final JTextField textFieldColumn;

	protected JButton button;

	protected PlayController playController;

	CoordinateView(PlayController playController) {
		this.playController = playController;
		this.setLayout(new GridBagLayout());
		this.labelRow = new JLabel(MessageView.READ_ROW.getMessage());
		this.labelColumn = new JLabel(MessageView.READ_COLUMN.getMessage());
		this.textFieldRow = new JTextField(1);
		this.textFieldColumn = new JTextField(1);
		this.add(labelRow, new Constraints(0, 1, 1, 1));
		this.add(textFieldRow, new Constraints(0, 2, 1, 1));
		this.add(labelColumn, new Constraints(0, 3, 1, 1));
		this.add(textFieldColumn, new Constraints(0, 4, 1, 1));
	}

	public abstract void actionPerformed(final ActionEvent event);

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