package TicTacToe.tictactoe.models;

import TicTacToe.tictactoe.types.StateValue;

public class State {

	private StateValue stateValue;

	public State() {
		this.reset();
	}

	public void reset() {
		this.stateValue = StateValue.INITIAL;
	}

	public void nextState() {
		this.stateValue = StateValue.values()[this.stateValue.ordinal() + 1];
	}

	public StateValue getValueState() {
		return this.stateValue;
	}

}
