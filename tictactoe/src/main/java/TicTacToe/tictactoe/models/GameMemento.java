package TicTacToe.tictactoe.models;

public class GameMemento {

	private Board board;
	private Turn turn;
	
	public GameMemento(Board board, Turn turn) {
		this.board = board.copy();
		this.turn = turn.copy();
	}

	public Turn getTurn() {
		return this.turn;
	}

	public Board getBoard() {
		return this.board;
	}

}
