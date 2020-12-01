package TicTacToe.tictactoe.models;

import TicTacToe.tictactoe.types.Error;
import TicTacToe.tictactoe.types.Token;

public class Game {
    
    private Board board;
    private Turn turn;
    
    public Game() {
        this.reset();
    }
    
    public void reset() {
        this.board = new Board();
	}
    
    public void setUsers(int users) {
        this.turn = new Turn(this.board);
		this.turn.setUsers(users);
    }

    public boolean isBoardComplete() {
        return this.board.isCompleted();
    }

    public boolean isUser() {
		return this.turn.isUser();
	}

    public Error put(Coordinate coordinate) {
    	Error error = this.turn.put(coordinate);
        if (error.isNull() && !this.board.isTicTacToe(this.turn.getToken())){
            this.turn.nextTurn(); 
        }
        return error;
    }

    public Error move(Coordinate origin, Coordinate target) {
    	Error error = this.turn.move(origin, target);
        if (error.isNull() && !this.board.isTicTacToe(this.turn.getToken())){
            this.turn.nextTurn();
        }
        return error;
    }

    public GameMemento createMemento() {
        return new GameMemento(this.board, this.turn);
	}

    public boolean isTicTacToe() {
        return this.board.isTicTacToe(this.turn.getToken());
    }

	public Token getToken(Coordinate coordinate) {
		return this.board.getToken(coordinate);
    }
    
    public Token getToken() {
		return this.turn.getToken();
	}

	public int getMaxPlayers() {
		return Turn.NUMBER_PLAYERS;
	}
	
	public void set(GameMemento memento) {
        this.turn.set(memento.getTurn().getToken().ordinal());
        for(int i=0; i<Coordinate.DIMENSION; i++){
            for(int j=0; j<Coordinate.DIMENSION; j++){
                Coordinate coordinate = new Coordinate(i,j);
                this.board.put(coordinate, memento.getBoard().getToken(coordinate));
            }
        }
    }

}