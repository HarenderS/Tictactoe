package TicTacToe.tictactoe.models;

public class GameMemento {

	private Board board;
	
	public GameMemento(Board board) {
		this.board = board;
	}

	public Turn getTurn() {
		return null;
	}

	public Board getBoard() {
		return this.board;
	}

}
