package TicTacToe.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {

	private List<GameMemento> mementos;
	private Game game;
	private int firstPrevious;

	public GameRegistry(Game game) {
		this.game = game;
		this.mementos = new ArrayList<GameMemento>();
		this.firstPrevious = 0;
		this.mementos.add(this.firstPrevious, this.game.createMemento());
	}

	public void register() {
		for (int i = 0; i < this.firstPrevious; i++) {
			this.mementos.remove(0);
			this.firstPrevious--;
		}
		this.mementos.add(this.firstPrevious, this.game.createMemento());
	}

	public Boolean isUndoable() {
		return this.firstPrevious < this.mementos.size() - 1;
	}

	public void undo() {
		this.firstPrevious++;
	    this.game.set(this.mementos.get(this.firstPrevious));
	}

	public Boolean isRedoable() {
		return true;
	}
}
